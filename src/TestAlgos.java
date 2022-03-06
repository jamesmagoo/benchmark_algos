/**
 * 
 */

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

		for (int i = testArray.length -1; i > 0; i--) {
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
		System.out.printf("Bubble Sort O(N^2) took (ms): %.3f %n", elapsedMillis);
		return elapsedMillis;
	}

	

}
