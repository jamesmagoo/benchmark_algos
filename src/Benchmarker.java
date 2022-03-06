
/**
 * This class benchmarks various sorting algorithms' run times for varying sizes of N.
 * GMIT - Computational Thinking & Algorithms 
 * Lecturer: Dominic Carr
 * 
 * @author James McGauran
 * @date 5 Mar 2022
 *
 */
public class Benchmarker {

	public int[] testArray;
	public int arraySize;
	

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

	// BUBBLE SORT ALGORITHM
	public double bubbleSort() {

		// start timer
		double startTime = System.nanoTime();

		for (int i = arraySize - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (testArray[j] > testArray[j + 1]) {
					// swap array values
					swapValues(j, j + 1);
				}
			}
		}
		// stop timer
		double endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime);
		double elapsedMillis = timeElapsed / 1000000;
		System.out.printf("Bubble Sort O(N^2) took (ms): %.3f %n", elapsedMillis);
		return elapsedMillis;
	}

	// function to swap array values
	// Credit: Derek Banas (YoutTube)
	public void swapValues(int i1, int i2) {
		int temp = testArray[i1];
		testArray[i1] = testArray[i2];
		testArray[i2] = temp;
	}

	public static void main(String[] args) {
		
	
	// array to store sorting times
		double[] bubbleSortTimes = new double[10];

	// Test Bubble sort algorithm 10 times for average (N=1000)
		for (int i = 0; i < 10; i++) {
			// Regenerate values to the arrays
			Benchmarker b1 = new Benchmarker(20000);
			b1.generateRandomArray();
			//b1.printArray();
			//double time = b1.bubbleSort();
			double time = TestAlgos.bubbleSort(b1.testArray);
			//b1.printArray();
			// append to time array
			bubbleSortTimes[i] = time ;
			System.err.printf("%.3f %n", time);
		}
		
		for(int j=0 ; j< bubbleSortTimes.length; j++) {
			System.out.printf(bubbleSortTimes[j] + " , ");
		}

		// System.out.printf("%1s %-7s %-7s %-6s %-6s%n", "SIZE", "N=500", "N=1000",
		// "N=2000", "N=3000");

	}

}
