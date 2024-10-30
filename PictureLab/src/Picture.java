import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /*
         * not needed but use it to show students the implicit call to super() child
         * constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     * 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * 
     * @param height the height of the desired picture
     * @param width  the width of the desired picture
     */
    public Picture(int height, int width) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     * 
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * 
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * 
     * @return a string with information about the picture such as fileName, height
     *         and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    /**
     * TODO: Activity 5, Exercise 3.
     * Method to set all colors other than blue to 0
     */
    public void keepOnlyBlue() {
    	Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setGreen(0);
                pixelObj.setRed(0);
            }
        }
    }

    /**
     * TODO: Activity 5, Exercise 4.
     * Method to negate the color of all pixels
     */
    public void negate() {
    	Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    /**
     * TODO: Activity 5, Exercise 5.
     * Method to negate the color of all pixels
     */
    public void grayscale() {
    	Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
            	int average = (int)pixelObj.getAverage();
            	pixelObj.setRed(average);
                pixelObj.setGreen(average);
                pixelObj.setBlue(average);
            }
        }
    }

    /**
     * TODO: Activity 5, Exercise 6 - Challenge!!
     * Method to make fish to stand out in the water image.
     */
    public void fixUnderwater() {
    	Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
            	if(pixelObj.getGreen() < pixelObj.getBlue()) {
            		pixelObj.setRed(255);
            		pixelObj.setGreen(192);
            		pixelObj.setBlue(203);
            	}
            }
        }
    }

    /**
     * Method that mirrors the picture around a vertical mirror in the center of the
     * picture from left to right
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
    /**
     * TODO: Activity 6, Exercise 1.
     * Method to mirror the image around the mirror
     * placed vertically from right to left. 
     */
    public void mirrorVerticalRightToLeft() {
    	Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = pixels.length - 1; row >= 0; row--) {
            for (int col = 0; col < width / 2; col++) {
            	rightPixel = pixels[row][width - 1 - col];
                leftPixel = pixels[row][col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }
    
    /**
     * TODO: Activity 6, Exercise 2.
     * Method to mirror the image around the mirror
     * placed horizontally from top to bottom. 
     */
    public void mirrorHorizontal() {
    	Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int length = pixels.length;
        for(int row = 0; row < length / 2; row++) {
        	for(int col = 0; col < pixels[0].length; col++) {
        		topPixel = pixels[row][col];
        		bottomPixel = pixels[length - 1 - row][col];
        		bottomPixel.setColor(topPixel.getColor());
        	}
        }
    }
    
    /**
     * TODO: Activity 6, Exercise 3.
     * Method to mirror the image around the mirror
     * placed horizontally from bottom to top. 
     */
    public void mirrorHorizontalBotToTop() {
    	Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int length = pixels.length;
        for(int row = length - 1; row >= length / 2; row--) {
        	for(int col = 0; col < pixels[0].length; col++) {
        		bottomPixel = pixels[row][col];
        		topPixel = pixels[length - 1 - row][col];
        		topPixel.setColor(bottomPixel.getColor());
        	}
        }
    }

    /**
     * TODO: Activity 6, Exercise 4 - Challenge!
     * Method to mirror the image around the mirror
     * placed diagonally from bottom-left to top-right. 
     */
    public void mirrorDiagonal() {
    	Pixel[][] pixels = this.getPixels2D();
        int iterationLength = 1;
        for(int row = 0; row < iterationLength; row++) {
        	for(int col = 0; col < iterationLength; col++) {
        		// Mirror the pixel
        		pixels[col][row].setRed(pixels[row][col].getRed());
        		pixels[col][row].setGreen(pixels[row + 50][col].getGreen());
        		pixels[col][row].setBlue(pixels[row][col].getBlue());
        	}
        	if(iterationLength < pixels.length) {
            	iterationLength++;
        	}
        }
    }

    /**
     * TODO: Activity 7, Exercise 1.
     * Mirror just part of a picture of a temple.
     * Modify this method to return the number of times spent 
     * in the inner-most loop of the method.  
     */
    public int mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        int count = 0;
        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {

                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }
        
        // TODO: return the number of times spent in the inner loop
        return count;
    }
    
    /**
     * TODO: Activity 7, Exercise 2
     * Method to mirror the arms of the snowman.
     */
    public void mirrorArms() {
    	Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int length = pixels.length;
        for(int row = 159; row < 190; row++) {
        	for(int col = 105; col < 169; col++) {
        		topPixel = pixels[row][col];
        		bottomPixel = pixels[row + 50][col];
        		bottomPixel.setColor(topPixel.getColor());
        	}
        }
        // (168, 238) to (196, 294)
        for(int row = 168; row < 196; row++) {
        	for(int col = 238; col < 294; col++) {
        		topPixel = pixels[row][col];
        		bottomPixel = pixels[row + 50][col];
        		bottomPixel.setColor(topPixel.getColor());
        	}
        }
    }
    
    /**
     * TODO: Activity 7, Exercise 3
     * Method to mirror the seagull to the right such that
     * there are two seagulls on the beach.
     */
    public void mirrorGull() {
    	// (234, 239) to (322, 345)
    	 Pixel[][] pixels = this.getPixels2D();
         Pixel leftPixel = null;
         Pixel rightPixel = null;
         int width = pixels[0].length;
         for (int row = 0; row < pixels.length; row++) {
             for (int col = 0; col < width / 2; col++) {
                 leftPixel = pixels[row][col];
                 rightPixel = pixels[row][width - 1 - col];
                 rightPixel.setColor(leftPixel.getColor());
             }
         }
    }
    
    /**
     * copy from the passed fromPic to the specified startRow and startCol in the
     * current picture
     * 
     * @param fromPic  the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] fromPixels = fromPic.getPixels2D();
        Pixel[][] toPixels = this.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
                fromRow < fromPixels.length && toRow < toPixels.length;
                fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol;
                    fromCol < fromPixels[0].length && toCol < toPixels[0].length;
                    fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }
    
    /**
     * TODO: Activity 8, Exercise 1
     * Method to copy the rectangular part of a picture
     * from (startRow, startCol) to (endRow, endCol) into this picture.
     * @param fromPic the picture to copy from
     * @param fromRow the start row to copy from
     * @param fromCol the start column to copy from
     * @param fromWidth the width of the rectangle to copy from
     * @param fromHeight the height of the rectangle to copy from
     * @param toRow the row of this image to start coping into
     * @param toCol the column of this image to start coping into
     */
    public void copy(Picture fromPic,
            int fromStartRow, int fromStartCol,
            int fromEndRow, int fromEndCol,
            int toStartRow, int toStartCol) {
    	Pixel fromPixel = null;     
    	Pixel toPixel = null;     
    	Pixel[][] toPixels = this.getPixels2D();     
    	Pixel[][] fromPixels = fromPic.getPixels2D();     
    	for (int fromRow = fromStartRow, toRow = toStartRow; fromRow < fromEndRow;fromRow++, toRow++) {      
    		for (int fromCol = fromStartCol, toCol = toStartCol; fromCol < fromEndCol; fromCol++, toCol++)       {         
    			fromPixel = fromPixels[fromRow][fromCol];         
    			toPixel = toPixels[toRow][toCol];         
    			toPixel.setColor(fromPixel.getColor());       
    		} 
    	}
    	
    }
    	
    
    /** Method to create a collage of several pictures */
    public void createCollage() {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1, 0, 0);
        this.copy(flower2, 100, 0);
        this.copy(flower1, 200, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 300, 0);
        this.copy(flower1, 400, 0);
        this.copy(flower2, 500, 0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }
    
    /**
     * TODO: Activity 8, Exercise 2
     * Method to create your own collage
     */
    public void myCollage() {
    	Picture beach = new Picture("beach.jpg");
        Picture snowman = new Picture("snowman.jpg");
        this.copy(beach, 0, 0);
        this.copy(snowman, 100, 0);
        this.copy(beach, 200, 0);
        Picture snowmanNoBlue = new Picture(snowman);
        snowmanNoBlue.zeroBlue();
        this.copy(snowmanNoBlue, 300, 0);
        this.copy(beach, 400, 0);
        this.copy(snowman, 500, 0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }

    /**
     * Method to show large changes in color
     * 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
        for (int row = 0; row < pixels.length - 1; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row + 1][col];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
        
    }

    /*
     * Main method for testing - each class in Java can have a main method
     */
    public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
        Picture beach2 = new Picture("beach.jpg");
        beach2.keepOnlyBlue();
        beach2.explore();
    }

} // this } is the end of class Picture, put all new methods before this
