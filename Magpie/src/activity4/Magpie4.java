package activity4;

/**
 * A program to carry on conversations with a human user.<br>
 * This version:<br>
 * - Uses advanced search for keywords<br>
 * - Will transform statements as well as react to keywords<br>
 * @author Laurie White
 * @version April 2012
 */
public class Magpie4
{
    /**
     * Get a default greeting.
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * @param statement - the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        String response = "";
        
        if (statement.length() == 0) {
            response = "Say something, please.";
        } else if (findKeyword(statement, "no") >= 0) {
            response = "Why so negative?";
        } else if (findKeyword(statement, "mother") >= 0
                || findKeyword(statement, "father") >= 0
                || findKeyword(statement, "sister") >= 0
                || findKeyword(statement, "brother") >= 0) {
            response = "Tell me more about your family.";
        } else if (findKeyword(statement, "I want to", 0) >= 0) {
            // Responses which require transformations
            response = transformIWantToStatement(statement);
        } else if(findKeyword(statement, "I want", 0) >= 0) {
            response = transformIWantStatement(statement);
        } else {
            // Look for a two word (you <something> me) pattern
            int iYou = findKeyword(statement, "you", 0);
            int i = findKeyword(statement, "I", 0);
            if (iYou>= 0 && findKeyword(statement, "me", iYou) >= 0) {
               response = transformYouMeStatement(statement);    
            } else if(i >= 0 && findKeyword(statement, "you", i) >= 0) {
                response = transformISomethingYouStatement(statement);
            } else {
                response = getRandomResponse();
            }
        }
        
        return response;
    }
    
    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement) {
        // Remove spaces before and after statement, if any.
        statement = statement.trim();
        
        // Remove the final period, if there is one
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        
        int iWant = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(iWant + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }
    /**
     * Transforms the statement in the form I want <something>
     * to Would you really be happy if you had <something>?
     * @param statement
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement) {
        // Remove spaces before and after statement
        statement = statement.trim();

        // Remove the final period, if there is one.
        String lastChar = statement.substring(statement.length() - 1);
        if(lastChar.equals(".")) {
            statement = statement.substring(0, statement.length()- 1);
        }
        int iWant = findKeyword(statement, "I want", 0);
        String restOfStatement = statement.substring(iWant + 6).trim();
        return "Would you really be happy if you had " + restOfStatement + "?";
    }
    /**
     * Transforms statement like I <something> you to
     * Why do you <something> me?
     * @param statement
     * @return
     */
    private String transformISomethingYouStatement(String statement) {
        // Remove spaces before and after statement
        statement = statement.trim();

        // Remove the final period, if there is one.
        String lastChar = statement.substring(statement.length() - 1);
        if(lastChar.equals(".")) {
            statement = statement.substring(0, statement.length()- 1);
        }
        int iSomething = findKeyword(statement, "I", 0);
        int youSomething = findKeyword(statement, "you", iSomething);

        String restOfStatement = statement.substring(iSomething + 1, youSomething).trim();
        return "Why do you " + restOfStatement + " me?";
    }
    
    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement) {
        // Remove spaces before and after statement, if any.
        statement = statement.trim();
        
        // Remove the final period, if there is one
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        
        int iYou = findKeyword (statement, "you", 0);
        int iMe = findKeyword (statement, "me", iYou + 3);
        
        String restOfStatement = statement.substring(iYou + 3, iMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }
    
    /**
     * Search for one word in phrase. The search is case insensitive. 
     * This method will check that the given goal is not a substring 
     * of a longer string (for example, "I know" does NOT contain the
     * word "no").
     * @param statement - the string to search
     * @param goal - the string to search for
     * @param iStart - the index in the string where to start searching from.
     * @return the index of the first occurrence of goal in statement 
     *         or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int iStart)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in
        // the line below
        int i = phrase.indexOf(goal, iStart);

        // Refinement--make sure the goal isn't part of a
        // word
        while (i >= 0) {
            // Find the string of length 1 preceding word, if one exists
            String before = " ";
            if (i > 0) {
                before = phrase.substring(i - 1, i);
            }
            
            // Find the string of length 1 following word, if one exists
            String after = " ";
            if (i + goal.length() < phrase.length()) {
                after = phrase.substring(
                        i + goal.length(),
                        i + goal.length() + 1);
            }

            // If before and after aren't letters, we've found the word
            if (!isLetter(before) && !isLetter(after)) {
                return i;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            i = phrase.indexOf(goal, i + 1);
        }

        return -1;
    }
    
    /**
     * Determines if a string contains one alphabetic character only (a-z).
     * @param str - string to test
     * @return true if the string is one character, in alphabetic range (a-z).
     */
    public boolean isLetter(String str) {
        return (str.length() == 1 
            && str.compareTo("a") >= 0
            && str.compareTo("z") <= 0);
    }

    /**
     * Search for one word in phrase. The search is not case sensitive.
     * This method will check that the given goal is not a substring of
     * a longer string (for example, "I know" does not contain "no").
     * The search begins at the beginning of the string.
     * @param statement - the string to search
     * @param goal - the string to search for
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal) {
        return findKeyword(statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a noncommittal string
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 4;
        int whichResponse = (int) (Math.random() * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            response = "Hmmm.";
        } else if (whichResponse == 2) {
            response = "Do you really think so?";
        } else if (whichResponse == 3) {
            response = "You don't say.";
        }

        return response;
    }
}
