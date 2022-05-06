/**
 * This class benchmarks various sorting algorithms' run times for varying sizes
 * of N. GMIT - Computational Thinking & Algorithms Lecturer: Dominic Carr
 * 
 * @author James McGauran
 * @date 5 Mar 2022
 *
 */
public class Benchmarker {

	public int[] testArray;
	public int arraySize;
	// arrays to store average sorting times
	private static double[] bubbleSortResults = new double[9];
	private static double[] selectionSortResults = new double[9];
	private static double[] insertionSortResults = new double[9];
	private static double[] bucketSortResults = new double[9];
	private static double[] mergeSortResults = new double[9];

	// Array Constructor
	Benchmarker(int size) {
		arraySize = size;
		testArray = new int[size];
	}

	// method to populate an array with random numbers
	public void generateRandomArray() {
		for (int i = 0; i < arraySize; i++) {
			testArray[i] = (int) (Math.random() * 100) + 10;
		}
	}

	// method to print out array for debugging/checking
	public void printArray() {
		for (int i = 0; i < testArray.length; i++) {
			System.out.printf(testArray[i] + ",");

		}
	}

	// method to get average from array of 10 run times
	public static double getAverage(double[] arr) {
		double sum = 0;
		for (double d : arr)
			sum += d;
		double average = 1.0d * sum / arr.length;
		return average;
	}
	
	// method to print out final benchmark results
	public static void displayResults() {

		// define format parameters for printf output
		String headerFormat = "%12s";
		String format = "%12.3f";
		// print table header
		System.out.printf("%-15s", "Size:");
		for (int n = 100; n <= 25600; n *= 2) {
			System.out.printf(headerFormat, "N=" + n);
		}
		// print bubble sort results
		System.out.println();
		System.out.printf("%-15s", "Bubble Sort:");
		for (int i = 0; i < bubbleSortResults.length; i++) {
			System.out.printf(format, bubbleSortResults[i]);
		}
		// print merge sort results
		System.out.println();
		System.out.printf("%-15s", "Merge Sort:");
		for (int i = 0; i < mergeSortResults.length; i++) {
			System.out.printf(format, mergeSortResults[i]);
		}
		// print bucket sort results
		System.out.println();
		System.out.printf("%-15s", "Bucket Sort:");
		for (int i = 0; i < bucketSortResults.length; i++) {
			System.out.printf(format, bucketSortResults[i]);
		}
		// print selection sort results
		System.out.println();
		System.out.printf("%-15s", "Selection Sort:");
		for (int i = 0; i < selectionSortResults.length; i++) {
			System.out.printf(format, selectionSortResults[i]);
		}
		// print insertion sort results
		System.out.println();
		System.out.printf("%-15s", "Insertion Sort:");
		for (int i = 0; i < insertionSortResults.length; i++) {
			System.out.printf(format, insertionSortResults[i]);
		}

	}

	public static void main(String[] args) {
		// initialise local arrays to store sorting times
		double[] bubbleSortTimes = new double[10];
		double[] selectionSortTimes = new double[10];
		double[] insertionSortTimes = new double[10];
		double[] bucketSortTimes = new double[10];
		double[] mergeSortTimes = new double[10];
		// set count for results arrays
		int count = 0;
		// loop through increasing data sizes
		// int n = 100; n <= 25600; n*=2
		for (int n = 100; n <= 25600; n *= 2) {
			
			// Construct array for size n
			Benchmarker b1 = new Benchmarker(n);
			
			// Test each algorithm 10 times for average
			for (int i = 0; i < 10; i++) {
				// Regenerate values to the array
				b1.generateRandomArray();
				double bubbleTime = TestAlgos.bubbleSort(b1.testArray);
				
				// produce unsorted array for next test
				b1.generateRandomArray();
				double selectionTime = TestAlgos.selectionSort(b1.testArray);
				
				// produce unsorted array for next test
				b1.generateRandomArray();
				double insertionTime = TestAlgos.insertionSort(b1.testArray);
				
				// produce unsorted array for next test
				b1.generateRandomArray();
				//b1.printArray();
				double bucketTime = TestAlgos.bucketSort(b1.testArray, n);
				//System.out.println();
				//b1.printArray();
				
				// produce unsorted array for next test
				b1.generateRandomArray();
				double mergeTime = TestAlgos.mergeSort(b1.testArray, 0, b1.testArray.length -1);
				
				// append to local time array
				bubbleSortTimes[i] = bubbleTime;
				selectionSortTimes[i] = selectionTime;
				insertionSortTimes[i] = insertionTime;
				bucketSortTimes[i] = bucketTime;
				mergeSortTimes[i] = mergeTime;
			}

			// calculate average of ten runs per size
			double avgBubble = getAverage(bubbleSortTimes);
			double avgSelection = getAverage(selectionSortTimes);
			double avgInsertion = getAverage(insertionSortTimes);
			double avgBucket = getAverage(bucketSortTimes);
			double avgMerge = getAverage(mergeSortTimes);

			// append average to results arrays
			Benchmarker.bubbleSortResults[count] = avgBubble;
			Benchmarker.selectionSortResults[count] = avgSelection;
			Benchmarker.insertionSortResults[count] = avgInsertion;
			Benchmarker.bucketSortResults[count] = avgBucket;
			Benchmarker.mergeSortResults[count] = avgMerge;
			count++;
		}
		
		

		// TODO: Add loading feedback for UX
		displayResults();

	}

}
