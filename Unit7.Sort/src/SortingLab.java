import java.util.Arrays;
import java.util.Random;

import javax.xml.crypto.Data;

import graph.Graph;

public class SortingLab {

	private static final int NUMBERS_RANGE = 10000;
	/*
	 * Generate a random array of @arraySize numbers, each in the range
	 * [-NUMBER_RANGE, NUMBER_RANGE]
	 */
	private static int[] createRandomArray(int arraySize) {
		int[] arr = new int[arraySize];
		Random rnd = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rnd.nextInt(2 * NUMBERS_RANGE + 1) - NUMBERS_RANGE;
		}
		return arr;
	}
	
	/*
	 * Generate a random array of @arraySize numbers. Array starts with
	 * a random number in the range [-NUMBER_RANGE, NUMBER_RANGE] and each
	 * number is larger than the previous by a random value in [0, 10] range.
	 */
	private static int[] createSortedRandomArray(int arraySize) {
		int[] arr = new int[arraySize];
		Random rnd = new Random();
		arr[0] = (rnd.nextInt(2 * NUMBERS_RANGE + 1) - NUMBERS_RANGE) / 10;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i-1] + rnd.nextInt(11);
		}
		return arr;
	}
	
	/*
	 * Sort the @arr array using java default Arrays.sort() method.
	 * Returns the execution time.
	 */
	public static double javaArraySort(int[] arr) {
		double result = System.nanoTime();
		Arrays.sort(arr);
		return System.nanoTime() - result;
	}
	
	/*
	 * Sort the @arr array using selection sort method.
	 * Returns the execution time.
	 */
	public static double selectionSort(int[] arr) {
		double result = System.nanoTime();

		for(int step = 0; step < arr.length - 2; step++) {
			//search
			int iMin = step;
			for(int i = step; i < arr.length; i++) {
				//select
				if(arr[i] < arr[iMin]) {
					iMin = i;
				}
			}
			// swap
			int temp = arr[step];
			arr[step] = arr[iMin];
			arr[iMin] = temp;
		}
		
		return System.nanoTime() - result;
	}
	
	/*
	 * Sort the @arr array using the insertion sort method.
	 * Returns the execution time.
	 */
	public static double insertionSort(int[] arr) {
		double result = System.nanoTime();

		/* FILL IN YOUR INSERTION SORT IMPLEMENTATION HERE */
		for (int s = 1; s < arr.length; s++) {
			// Extract
			int testElem = arr[s];
			int i = s;
			// Slide
			while (i > 0 && arr[i-1] > testElem) {
				arr[i] = arr[i-1];
				i --;
			}
			// Insert
			arr[i] = testElem;
		}
		
		return System.nanoTime() - result;
	}
	
	private static final int NUM_SORTS = 200;
	private static final int SIZE_MULTIPLIER = 40;
	/*
	 * Run a sequence of experiments. Each experiment is executing a specific
	 * sorting algorithm, NUM_SORTS times, over an array of increasing size.
	 * The size of the array being sorted and the execution times are stored
	 * in data arrays which are further plotted in a graph.
	 */
	public static void main(String[] args) {
		double[] sizeOfArray = new double[NUM_SORTS];
		double[] timeArraySort = new double[NUM_SORTS];
		double[] timeSelection = new double[NUM_SORTS];
		double[] timeInsertion = new double[NUM_SORTS];
		
		for (int i = 0; i < NUM_SORTS; i++) {
			int[] arr = createRandomArray((i + 1) * SIZE_MULTIPLIER);
			sizeOfArray[i] = arr.length;
			timeArraySort[i] = javaArraySort(arr.clone());
			timeSelection[i] = selectionSort(arr.clone());
			timeInsertion[i] = insertionSort(arr.clone());
		}
		
		Graph g1 = new Graph();
		g1.add("unsorted.java", sizeOfArray, timeArraySort);
		g1.add("unsorted.selection", sizeOfArray, timeSelection);
		g1.add("unsorted.insertion", sizeOfArray, timeInsertion);
		g1.plot();
		
		for (int i = 0; i < NUM_SORTS; i++) {
			int[] arr = createSortedRandomArray((i + 1) * SIZE_MULTIPLIER);
			sizeOfArray[i] = arr.length;
			timeArraySort[i] = javaArraySort(arr.clone());
			timeSelection[i] = selectionSort(arr.clone());
			timeInsertion[i] = insertionSort(arr.clone());
		}
		
		Graph g2 = new Graph();
		g2.add("sorted.java", sizeOfArray, timeArraySort);
		g2.add("sorted.selection", sizeOfArray, timeSelection);
		g2.add("sorted.insertion", sizeOfArray, timeInsertion);
		g2.plot();
	}
}
