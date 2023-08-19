package best.project.lore.algorithms.utils;

public class SortUtils {
	
	private SortUtils() {
		//
	}
	
	public static boolean isSorted(int[] arrayToCheck) {
		boolean isArraySorted = Boolean.TRUE;
		for(int i = 0; i < arrayToCheck.length - 1; i++) {
			if(arrayToCheck[i] > arrayToCheck[i+1]) {
				isArraySorted = Boolean.FALSE;
				break;
			}
		}
		return isArraySorted;
	}
	
	public static void printArray(int[] arrayToPrint) {
		for (int i : arrayToPrint) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

}
