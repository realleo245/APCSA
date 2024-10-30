public class IntArrayWorker {
    /** two dimensional matrix */
    private int[][] matrix = null;
    
    /**
     * accessor for the private field matrix.
     */
    public int[][] getMatrix() {
        return matrix;
    }
    
    /**
     * setter for the the private field matrix.
     */
    public void setMatrix(int[][] theMatrix) {
        matrix = theMatrix;
    }
    
    /**
     * Method to fill the matrix with an increasing count
     */
    public void fillCount() {
        int numCols = matrix[0].length;
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < numCols; col++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }
    
    /**
     * fills the array with a pattern:
     * 2's on the diagonal,
     * 3's under (to the left of) the diagonal,
     * 1's over (to the right of) the diagonal
     */
    public void fillPattern1() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row < col)
                    matrix[row][col] = 1;
                else if (row == col)
                    matrix[row][col] = 2;
                else
                    matrix[row][col] = 3;
            }
        }
    }
    
    /**
     * Method to return the total of all numbers in the matrix
     */
    public int getTotal() {
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                total = total + matrix[row][col];
            }
        }
        return total;
    }

    /**
     * Method to return the total of all numbers in the matrix
     * using a nested for-each loop
     */
    public int getTotalNested() {
        int total = 0;
        for (int[] rowArray : matrix) {
            for (int item : rowArray) {
                total = total + item;
            }
        }
        return total;
    }

    /**
     * print the values in the matrix in rows and columns
     */
    public void print() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * TODO: Activity 4, Exercise 1.
     * Method to return the number of times n is found in the matrix
     */
    public int getCount(int n) {
    	int count = 0;
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[i].length; j++) {
    			int cur = matrix[i][j];
    			if(cur == n) {
    				count++;
    			}
    		}
    	}
        return count;
    }
    
    /**
     * TODO: Activity 4, Exercise 2.
     * Method to return the largest number in the matrix.
     */
    public int getLargest() {
    	int largest = Integer.MIN_VALUE;
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[i].length; j++) {
    			int cur = matrix[i][j];
    			if(cur > largest) {
    				largest = cur;
    			}
    		}
    	}
        return largest;
    }
    
    /**
     * TODO: Activity 4, Exercise 3.
     * Method to return the total of all numbers in a given column.
     */
    public int getColTotal(int col) {
        int[] column = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
        	column[i] = matrix[i][col]; 
        }
        return sum(column);
    }
    private int sum(int[] list) {
    	int sum = 0;
    	for(int num : list) {
    		sum += num;
    	}
    	return sum;
    }
}