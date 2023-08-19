package best.project.lore.algorithms.sort.impl;

import best.project.lore.algorithms.sort.ISorter;

//Time Complexity O(n log n)
//Space Complexity O(n)
public class MergeSorter implements ISorter {

	@Override
	public int[] sort(int[] arrayToSort) {
		long startTime = System.nanoTime();
		mergeSort(arrayToSort);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Duration = " + duration);
		return arrayToSort;
	}
	
	public void mergeSort(int[] arrayToSort) {
		
		if(arrayToSort.length < 2) {
			return;
		}
		
		int middleIndex = arrayToSort.length / 2;
		
		int[] leftHalf = new int[middleIndex];
		int[] rightHalf = new int[arrayToSort.length - middleIndex];
		
		for(int i = 0; i < middleIndex; i++) {
			leftHalf[i] = arrayToSort[i];
		}
		
		for(int i = middleIndex; i < arrayToSort.length; i++) {
			rightHalf[i - middleIndex] = arrayToSort[i];
		}
		
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		merge(leftHalf, rightHalf, arrayToSort);
		
	}
	
	private void merge(int[] leftHalf, int[] rightHalf, int[] arrayMerged) {
		
		int countElementArray1 = leftHalf.length;
		int countElementArray2 = rightHalf.length;
		
		for(int i = 0; i < arrayMerged.length; i++) {
			if(countElementArray1 > 0 && countElementArray2 > 0) {
				if(leftHalf[leftHalf.length - countElementArray1] < rightHalf[rightHalf.length - countElementArray2]) {
					arrayMerged[i] = leftHalf[leftHalf.length - countElementArray1];
					countElementArray1--;
				} else {
					arrayMerged[i] = rightHalf[rightHalf.length - countElementArray2];
					countElementArray2--;
				}
			} else if (countElementArray1 > 0){
				arrayMerged[i] = leftHalf[leftHalf.length - countElementArray1];
				countElementArray1--;
			} else if (countElementArray2 > 0) {
				arrayMerged[i] = rightHalf[rightHalf.length - countElementArray2];
				countElementArray2--;
			}
		}
	}

}
