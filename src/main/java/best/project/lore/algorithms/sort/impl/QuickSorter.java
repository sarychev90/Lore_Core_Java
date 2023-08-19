package best.project.lore.algorithms.sort.impl;

import java.util.Random;

import best.project.lore.algorithms.sort.ISorter;

//Time Complexity O(n log n) -> -> O(n²)
//Space Complexity O(n)
public class QuickSorter implements ISorter {
	
	@Override
	public int[] sort(int[] arrayToSort) {
		long startTime = System.nanoTime();
		quicksort(arrayToSort, 0, arrayToSort.length-1);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Duration = " + duration);
		return arrayToSort;
	}
	
	private void quicksort(int[] arrayToSort, int lowestIntex, int highestIndex) {
	
		if(lowestIntex >= highestIndex) {
			return;
		}
		
		int pivotIndex = new Random().nextInt(highestIndex - lowestIntex) + lowestIntex;
		int pivot = arrayToSort[pivotIndex];
		swap(arrayToSort, pivotIndex, highestIndex);
	
		int leftPointer = partition(arrayToSort, lowestIntex, highestIndex, pivot);
		
		//sort left part
		quicksort(arrayToSort, lowestIntex, leftPointer-1);
		
		//sort right part
		quicksort(arrayToSort, leftPointer+1, highestIndex);
	}

	private int partition(int[] arrayToSort, int lowestIntex, int highestIndex, int pivot) {
		int leftPointer = lowestIntex;
		int rightPointer = highestIndex;
		
		while(leftPointer < rightPointer) {
			
			while (arrayToSort[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;	
			}
			
			while (arrayToSort[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;	
			}
			
			swap(arrayToSort, leftPointer, rightPointer);
		}
		swap(arrayToSort, leftPointer, highestIndex);
		return leftPointer;
	}

	private void swap(int[] arrayToSort, int lowestIntex, int highestIndex) {
		int tmp = arrayToSort[lowestIntex];
		arrayToSort[lowestIntex] = arrayToSort[highestIndex];
		arrayToSort[highestIndex] = tmp;
	}

	
}
