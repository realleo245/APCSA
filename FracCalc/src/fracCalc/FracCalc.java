package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A fraction calculator that can add, subtract, multiply, and divide fractions
 * @author s-llian
 *
 */
public class FracCalc {

    public static void main(String[] args) 
    {
    	System.out.println("Welcome to Frac Calc, a fraction calculator that always breaks and is bad!");
    	Scanner console = new Scanner(System.in);
    	boolean isRunning = true;
    	//Get a fraction from the user
    	do {
    		System.out.print("Equation> ");
    		String line = console.nextLine();
    		if(!line.equals("quit")) {
    			// calculate the answer
    			String answer = produceAnswer(line);

    			// print the answer
    			System.out.println(answer);
    		}
    		else {
    			isRunning = false;
    		}
    	}
    	while(isRunning);
    	console.close();
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {   
        int iSpace = input.indexOf(" ");
        String operand1 = input.substring(0, iSpace);
        String operator = input.substring(iSpace + 1, iSpace + 2);
        String operand2 = input.substring(iSpace + 3);
    	
        int[] fraction1 = parseFraction(operand1);
        int[] fraction2 = parseFraction(operand2);
        String result = calculateAnswer(fraction1, operator, fraction2);
        // Checkpoint 2 code
        // result += "whole:" + fraction2[0] + " ";
        // result += "numerator:" + fraction2[1] + " ";
        // result += "denominator:" + fraction2[2];
        return result;
    }
    /**
     * 
     * @param potentialOperator
     * @return
     */
    public static boolean isOperator(String potentialOperator) {
        return potentialOperator.equals("+") || potentialOperator.equals("-") 
            || potentialOperator.equals("*") || potentialOperator.equals("/");
    }
    /**
     * @param operand
     * @return The fraction, parsed into an array of ints, with the elements corresponding to the whole number, numerator, and denominator
     */
    public static int[] parseFraction(String operand) {
    	int whole = 0;
    	int numerator = 0;
    	if(hasWhole(operand)) {
    		whole = getWhole(operand);
    	}
    	if(hasNumerator(operand)) {
    		numerator = getNumerator(operand);
    	}
    	int denominator = getDenominator(operand);
    	int[] fraction ={whole, numerator, denominator};
    	return fraction;
    }
    /**
     * @param operand
     * @return the whole number part of the operand
     */
    public static int getWhole(String operand) {
        // If there is no _, this means the entire operand is the whole
        if(!operand.contains("_")) {
            return Integer.parseInt(operand);
        }
    	int end = operand.indexOf("_");
        // Returns the operand between the beginning and _
    	return Integer.parseInt(operand.substring(0, end));
    }
    /**
     * @param operand
     * @return the numerator part of the operand
     */
    public static int getNumerator(String operand) {
    	int underScoreIndex = operand.indexOf("_");
    	int slashIndex = operand.indexOf("/");
        // Returns the operand between _ and /
    	return Integer.parseInt(operand.substring(underScoreIndex + 1, slashIndex));
    }
    /**
     * @param operand
     * @return the denominator part of the op erand
     */
    public static int getDenominator(String operand) {
    	int slashIndex = operand.indexOf("/");
        // If there is no slash, the denominator is then 1
        if(slashIndex == -1) {
            return 1;
        }
        // Returns the operand between / and the end
    	return Integer.parseInt(operand.substring(slashIndex + 1));
    }
    /**
     * @param operand
     * @return whether the operand has a whole number
     */
    public static boolean hasWhole(String operand) {
    	return operand.contains("_") || !operand.contains("/");
    }
    /**
     * @param operand
     * @return Whether the operand has a numerator
     */
    public static boolean hasNumerator(String operand) {
    	return operand.contains("/");
    }
    /**
     * @param fraction1
     * @param operator
     * @param fraction2
     * @return The result of the operation as a String
     */
    public static String calculateAnswer(int[] fraction1, String operator, int[] fraction2) {
        String result = "";
        if(operator.equals("+")) {
            result = parseAnswerToString(addFractions(fraction1, fraction2));
        }
        else if(operator.equals("-")) {
            result = parseAnswerToString(subtractFractions(fraction1, fraction2));
        }
        else if(operator.equals("*")) {
            result = parseAnswerToString(multiplyFractions(fraction1, fraction2));
        }
        else if(operator.equals("/")) {
            result = parseAnswerToString(divideFractions(fraction1, fraction2));
        }
        return result;
    }
    /**
     * @param fraction1
     * @param fraction2
     * @return The sum of the 2 fractions as an simplified mixed fraction
     */
    public static int[] addFractions(int[] fraction1, int[] fraction2) {
        // If the fraction isn't improper
        // Purpose: to convert all of the fractions to improper
        if(fraction1.length != 2 || fraction2.length != 2) {
            // Add the fractions, converted to improper
            return addFractions(convertToImproper(fraction1), convertToImproper(fraction2));
        }
        // If the fractions don't have a common denominator
        // Purpose: to create a common denominator on both fractions
        else if(fraction1[1] != fraction2[1]) {
            int commonDenominator = findCommonDenominator(fraction1[1], fraction2[1]);
            // Add the fractions, converted with common denominators
            // To adjust numerators, we multiply the existing numerators by the common denominator 
            // divided by the existing denominator
            return addFractions(new int[] {fraction1[0] * (commonDenominator / fraction1[1]), commonDenominator},
                new int[] { fraction2[0] * (commonDenominator / fraction2[1]), commonDenominator});
        }
        else {
            // Otherwise, just add the numerators and keep the denominators
            int[] answer = new int[] {fraction1[0] + fraction2[0], fraction1[1]};
            return reduceFraction(answer);
        }
    }
    /**
     * @param fraction1
     * @param fraction2
     * @return The difference between the 2 fractions as an simplified mixed fraction
     */
    public static int[] subtractFractions(int[] fraction1, int[] fraction2) {
        // If either fraction isn't improper
        // Purpose: to turn both fractions into an improper fraction
        if(fraction1.length != 2 || fraction2.length != 2) {
            // Subtract the fractions converted to improper fraction
            return subtractFractions(convertToImproper(fraction1), convertToImproper(fraction2));
        }
        // If the 2 fractions have different denominators
        // Purpose: to create a common denominator of both fractions
        else if(fraction1[1] != fraction2[1]) {
            int commonDenominator = findCommonDenominator(fraction1[1], fraction2[1]);
            // Subtract the fraction, with common denominators. 
            // To adjust numerators, we multiply the numerator by the common denominator 
            // divided by the existing denominator
            return subtractFractions(new int[] {fraction1[0] * (commonDenominator / fraction1[1]), commonDenominator},
                new int[] { fraction2[0] * (commonDenominator / fraction2[1]), commonDenominator});
        }
        else {
            // Otherwise, just subtract the numerators and keep the denominators
            int[] answer = new int[] {fraction1[0] - fraction2[0], fraction1[1]};
            return reduceFraction(answer);
        }
    }
    /**
     * @param fraction1
     * @param fraction2
     * @return The product of the 2 fractions, always as an improper fraction
     */
    public static int[] multiplyFractions(int[] fraction1, int[] fraction2) {
        // Converts both fractions to improper fractions
        fraction1 = convertToImproper(fraction1);
        fraction2 = convertToImproper(fraction2);
        int[] result = new int[2];
        // Mulitplies both fractions
        if(fraction1[0] == 0 || fraction2[0] == 0) {
            result = new int[]{0};
            return result;
        }
        else {
            result[0] = fraction1[0] * fraction2[0];
            result[1] = fraction1[1] * fraction2[1];
            return reduceFraction(result);
        }
    }
    /**
     * @param fraction1
     * @param fraction2
     * @return The quotient of the 2 fractions
     */
    public static int[] divideFractions(int[] fraction1, int[] fraction2) {
        return multiplyFractions(fraction1, recipirocal(fraction2));
    }
    /**
     * @param answer
     * @return Converts the fraction to a String
     */
    public static String parseAnswerToString(int[] answer) {
        String result = "";
        if(answer.length == 3) {
            result = answer[0] + "_" + answer[1] + "/" + answer[2];
        }
        else if(answer.length == 2) {
            result = answer[0] + "/" + answer[1];
        }
        else if(answer.length == 1) {
            result += answer[0];
        }
        return result;
    }
    
   
    /**
     * @param fraction
     * @return The provided fractions as an improper fraction, if it's a mixed number, 
     * or returns the current fraction if it is a proper fraction
     * It should always return an int array of length 2
     */
    public static int[] convertToImproper(int[] result) {
        int[] improperFraction = new int[2];
        // If the fraction array is length 2, that means it's already improper
        if(result.length == 2) {
            improperFraction = result;
        }
        // If it's length 3, this means there's a serious chance it isn't improper
        else if(result.length == 3) {
            // If the whole part of the fraction is positive
            if(result[0] > 0) {
                // The numerator is now the whole * denominator + numerator
                improperFraction[0] = result[0] * result[2] + result[1];
            }
            // If the whole is 0
            else if(result[0] == 0) {
                // Then the numerator is just the uh... numerator
                improperFraction[0] = result[1];
            }
            // If the whole part of the fractions is negative
            else {
                // Then the numerator is now whole * denominator - numerator
                improperFraction[0] = result[0] * result[2] - result[1];
            }
            improperFraction[1] = result[2];
        }
        return improperFraction;
    }
    /**
     * @param fraction
     * @return The recipirocal of the provided fraction
     * as an int array of length 2
     */
    public static int[] recipirocal(int[] fraction) {
        // If the fraction isn't improper
        if(fraction.length != 2) {
            // Convert it to improper
            fraction = convertToImproper(fraction);
        }
        int[] recipirocal = new int[2];
        if(fraction.length == 2) {
            recipirocal[0] = fraction[1];
            recipirocal[1] = fraction[0];
        }
        return recipirocal;
    }
    /**
     * @param firstNumber
     * @param secondNumber
     * @return a possible common denominator of the two numbers (not necessarily the LCD)
     */
    public static int findCommonDenominator(int firstNumber, int secondNumber) {
        // The two denominators multipled is guaranteed to be a possible common denominator
        return firstNumber * secondNumber;
    }
    /**
     * @param fraction
     * @return The fraction simplified and proper
     */
    public static int[] reduceFraction(int[] fraction) {
        int[] simplifiedFraction = new int[3];
        // If the fraction is 0 or a whole number
        if(fraction.length == 1 || fraction[0] == 0) {
            // The simplified fraction is just itself
            simplifiedFraction = new int[]{0};
            return simplifiedFraction;
        }
        // If the fraction is already reduced
        else if(isReduced(fraction)) {
            simplifiedFraction = fraction;
        }
        else if(fraction.length == 2) {
            int gcd = gcd(fraction[0], fraction[1]);
            fraction[0] /= gcd;
            fraction[1] /= gcd;
            // If the fraction is 0
            if(fraction[0] == 0) {
                simplifiedFraction = new int[]{0};
            }
            // If the numerator is divisible by the denominator
            else if(fraction[0] % fraction[1] == 0) {
                simplifiedFraction = new int[]{fraction[0] / fraction[1]};
            }
            else if(isReduced(fraction)) {
                simplifiedFraction = fraction;
            }
            // If the absolute value of the numerator and denominator is simplified and the denominator is negative,
            // Something like 1/-2
            else if(isReduced(new int[]{Math.abs(fraction[0]), Math.abs(fraction[1])}) && fraction[1] < 0) {
                simplifiedFraction = new int[]{fraction[0] * -1, fraction[1] * -1};
            }
            else {
                // If the fraction is negative
                if(fraction[0] < 0) {
                    // Makes the numerator of the fraction positive and reduces it
                    int[] positiveFraction = reduceFraction(new int[]{fraction[0] * -1, fraction[1]});
                    // If the reduced fraction is not mixed
                    if(positiveFraction.length == 2) {
                        // Then there is no whole
                        simplifiedFraction[0] = 0;
                        simplifiedFraction[1] = positiveFraction[0];
                        simplifiedFraction[2] = positiveFraction[1];
                    }
                    // Otherwise, if it's mixed
                    if(positiveFraction.length == 3) {
                        simplifiedFraction[0] = positiveFraction[0] * -1;
                        simplifiedFraction[1] = positiveFraction[1];
                        simplifiedFraction[2] = positiveFraction[2];
                    }
                }
                // Otherwise, just simplify the fraction normally
                else {
                    simplifiedFraction[0] = fraction[0] / fraction[1];
                    simplifiedFraction[1] = fraction[0] % fraction[1];
                    simplifiedFraction[2] = fraction[1];
                }
                // If the fraction is negative
                if(simplifiedFraction[1] > 0 && simplifiedFraction[2] < 0) {
                    simplifiedFraction[2] = simplifiedFraction[2] * -1;
                }
            }
        }
        // Otherwise, if it's a mixed fraction already
        else if(fraction.length == 3) {
            int gcd = gcd(fraction[1], fraction[2]);
            fraction[1] /= gcd;
            fraction[2] /= gcd;
            // If the numerator is 0, then the fraction is simply the whole
            if(fraction[1] == 0) {
                simplifiedFraction = new int[]{fraction[0], 0};
            }
            // Otherwise, just set the numerator and denominator to the original fraction
            else {
                simplifiedFraction[1] = fraction[1];
                simplifiedFraction[2] = fraction[2];
            }
        }
        // If the whole is 0, then the fraction is simply the numerator and denominator
        if(simplifiedFraction[0] == 0 && fraction.length > 1) {
            simplifiedFraction = Arrays.copyOfRange(simplifiedFraction, 1, 3);
        }
        // Otherwise, if the numerator is 0
        else if(simplifiedFraction.length > 1 && simplifiedFraction[1] == 0 && simplifiedFraction[2] == 1) {
            simplifiedFraction = Arrays.copyOfRange(simplifiedFraction, 0, 1);
        }
        return simplifiedFraction;
    }
    /**
     * @param a
     * @param b
     * @return The gcd of a and b
     */
    public static int gcd(int a, int b) {
        if(b == 0) {
            return Math.abs(a);
        }
        else {
            return gcd(b, a % b);
        }
    }
    /**
     * @param fraction
     * @return Whether the fraction is simplified or not
     */
    public static boolean isReduced(int[] fraction) {
        // If the fraction is just the whole
        if(fraction.length == 1) {
            return true;
        }
        // Otherwise, if there is a numerator, the fraction will be reduced if the gcd of the numerator is 1,
        // the absolute value of the numerator is less than the denominator, and
        // the denominator is not 0
        else if(fraction.length == 2) {
            return gcd(fraction[0], fraction[1]) == 1 && Math.abs(fraction[0]) < Math.abs(fraction[1])
                && fraction[1] > 0;
        }
        // Otherwise, if the fraction is mixed, then its reduced if the gcd of numerator and dennominator is 1
        // and the numerator is less than the denominator
        else if(fraction.length == 3) {
            return gcd(fraction[1], fraction[2]) == 1 && fraction[1] < fraction[2];
        }
        else {
            return false;
        }
    }
}
