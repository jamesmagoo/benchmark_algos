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
	// array to store sorting times
	private static double[] bubbleSortResults = new double[10];
	private static double[] selectionSortResults = new double[10];
	private static String[][] results = new String[2][10];
			
	

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
	
	// method to print out final benchmark results
	public static void displayResults() {
		
		System.out.println("Size\tN=100\tN=200");
				
		//loop through results arrays to print results
		for (int i = 0; i < 10 ; i++) {
			System.out.printf(selectionSortResults[i]+"\t");
			System.out.printf(bubbleSortResults[i]+"\t");
		}
		
		// TODO: this probably needs to be a multi-dimensional string array
	}

	
	public static void main(String[] args) {
		// local array to store sorting times
		double[] bubbleSortTimes = new double[10];
		double[] selectionSortTimes = new double[10];
		// count for results arrays
		int count=0;
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
				// append to local time array
				bubbleSortTimes[i] = bubbleTime ;
				selectionSortTimes[i] = selectionTime;
				
				//System.err.printf("%.3f %n", time);
			}
			
			// calculate average of ten runs per size
			double avgBubble = getAverage(bubbleSortTimes);
			double avgSelection = getAverage(selectionSortTimes);
		    System.out.printf("AVERAGE BUBBLE SORT: %.3f %n" , avgBubble);
		    System.out.printf("AVERAGE SELECTION SORT: %.3f %n" , avgSelection);
		   
		    // append average to results arrays
		    Benchmarker.bubbleSortResults[count] = avgBubble;
		    Benchmarker.selectionSortResults[count]= avgSelection;
		    count++;
		}
	
		
		displayResults();

	}

}
