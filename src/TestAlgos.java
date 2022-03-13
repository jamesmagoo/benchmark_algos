/**
 * Class defines algorithms to be tested by Benchmarker
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
					testArray[j] = testArray[j+1];
					testArray[j+1] = temp;
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

		int inner=0, min=0;
		
		//outer counts up
		for (int outer = 0; outer < testArray.length -1; outer++) {
			min=outer;
			for(inner=outer+1; inner < testArray.length -1 ; inner++) {
				// find index of smallest value
				if(testArray[inner] < testArray[min]) {
					min=inner;
				}
			}
			// swap a[min] with a[outer]
			int temp = testArray[outer];
			testArray[outer]=testArray[min];
			testArray[min]=temp;
		}
		
		// stop timer
		double endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime);
		double elapsedMillis = timeElapsed / 1000000;
		return elapsedMillis;
	}

	

}
