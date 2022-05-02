import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Class defines algorithms to be tested by Benchmarker
 * 
 * @author James McGauran
 * @date 6 Mar 2022
 *
 */
public class TestAlgos {

	static long startTime;
	static long endTime;

	/**
	 * Bubble Sort Algorithm
	 * 
	 * @param testArray - the array to be sorted
	 * @return elapsedMillis - the algorithms runtime for benchmarking
	 *
	 */
	public static double bubbleSort(int[] testArray) {

		// start timer
		double startTime = System.nanoTime();

		// first for loop counts down from end of array
		for (int i = testArray.length - 1; i > 0; i--) {
			// second for loop counts up from start 'bubbling up'
			for (int j = 0; j < i; j++) {
				if (testArray[j] > testArray[j + 1]) {
					// swap array values
					int temp = testArray[j];
					testArray[j] = testArray[j + 1];
					testArray[j + 1] = temp;
				}
			}
		}
		// stop timer
		double endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime);
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	/**
	 * Selection Sort Algorithm
	 * 
	 * @param testArray - the array to be sorted
	 * @return elapsedMillis - the algorithms runtime for benchmarking
	 *
	 */
	public static double selectionSort(int[] testArray) {

		// start timer
		double startTime = System.nanoTime();

		int inner = 0, min = 0;

		// outer counts up
		for (int outer = 0; outer < testArray.length - 1; outer++) {
			min = outer;
			for (inner = outer + 1; inner < testArray.length - 1; inner++) {
				// find index of smallest value
				if (testArray[inner] < testArray[min]) {
					min = inner;
				}
			}
			// swap a[min] with a[outer]
			int temp = testArray[outer];
			testArray[outer] = testArray[min];
			testArray[min] = temp;
		}

		// stop timer
		double endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime);
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	/**
	 * Insertion Sort Algorithm
	 * 
	 * @param testArray - the array to be sorted
	 * @return elapsedMillis - the algorithms runtime for benchmarking
	 *
	 */

	public static double insertionSort(int[] testArray) {

		// start timer
		double startTime = System.nanoTime();

		// set key position at 1 & move through array
		for (int i = 1; i < testArray.length; i++) {
			int key = testArray[i];
			// check elements to the left using while loop
			int j = i - 1;
			// if > key =>move right by one position
			while (j >= 0 && testArray[j] > key) {
				testArray[j + 1] = testArray[j];
				j = j - 1;
			}
			// insert key at correct position
			testArray[j + 1] = key;
		}

		// stop timer
		double endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime);
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	/**
	 * Bucket Sort Algorithm
	 * 
	 * Credit & Reference: https://www.javatpoint.com/bucket-sort-in-java
	 * 
	 * @param array   - the array to be sorted
	 * @param bktSize - size of array to be sorted
	 * @return elapsedMillis - the algorithms runtime for benchmarking
	 *
	 */

	public static double bucketSort(int[] array, int bktSize) {
		// start timer
		double startTime = System.nanoTime();

		// creating a list of buckets for storing lists
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new List[bktSize];
		
		// Linked list with each bucket array index
		// as there may be hash collision
		for (int i = 0; i < bktSize; i++) {
			buckets[i] = new LinkedList<>();
		}
		// calculate the hash and assigns elements to the proper bucket
		for (int num : array) {
			buckets[hash(num, bktSize)].add(num);
		}
		// iterate over the buckets and sorts the elements
		for (List<Integer> bucket : buckets) {
			// sorts the bucket
			Collections.sort(bucket);
		}
		int index = 0;
		
		// gather the buckets after sorting
		for (List<Integer> bucket : buckets) {
			for (int num : bucket) {
				array[index++] = num;
			}
		}

		// stop timer
		double endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime);
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	// Hash function for Bucket Sort
	private static int hash(int num, int bucketSize) {
		return num / bucketSize;
	}

}
