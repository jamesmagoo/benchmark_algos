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
	public double[] bubbleSortResults = new double[10];
	

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
		for (double d : arr) sum += d;
		double average = 1.0d * sum / arr.length;
		return average ;
	}

	
	public static void main(String[] args) {
	// array to store sorting times
		double[] bubbleSortTimes = new double[10];
		double[] selectionSortTimes = new double[10];
		
		// loop through increasing data sizes 
		// int n = 100; n <= 25600; n*=2
		for (int n = 100; n <= 25600; n*=2) {
			// Construct array for size n
			Benchmarker b1 = new Benchmarker(n);
			// Test Bubble sort algorithm 10 times for average
			System.out.println("N="+ b1.testArray.length);
			for (int i = 0; i < 10; i++) {
				// Regenerate values to the array
				b1.generateRandomArray();
//				System.out.printf("%n");
//				b1.printArray();
				double bubbleTime = TestAlgos.bubbleSort(b1.testArray);
//				System.out.printf("%n");
//				System.out.printf("& after 1st sort");
//				System.out.printf("%n");
//				b1.printArray();
				// produce unsorted array for next test
				b1.generateRandomArray();
//				System.out.printf("%n");
//				System.out.printf("& between sorts");
//				System.out.printf("%n");
//				b1.printArray();
				double selectionTime = TestAlgos.selectionSort(b1.testArray);
//				System.out.printf("%n");
//				System.out.printf("& after 2nd sort");
//				System.out.printf("%n");
//				b1.printArray();
				// append to time array
				bubbleSortTimes[i] = bubbleTime ;
				selectionSortTimes[i] = selectionTime;
				//System.err.printf("%.3f %n", time);
			}
			
			double avgBubble = getAverage(bubbleSortTimes);
			double avgSelection = getAverage(selectionSortTimes);
		    System.out.printf("AVERAGE BUBBLE SORT: %.3f %n" , avgBubble);
		    System.out.printf("AVERAGE SELECTION SORT: %.3f %n" , avgSelection);
		    // append average to bubble sort results array
		    //bubbleSortResults[n] = avg;
		}
	
		
		// OUTPUT DATA IN TABLE
		System.out.printf("%5s %-7s %-7s %-7s %-7s %-7s %-7s %-7s %-7s %-7s %n ","SIZE", "N=100", "N=200","N=400","N=800","N=1600","N=3200","N=6400","N=12800","N=25600");

	}

}
