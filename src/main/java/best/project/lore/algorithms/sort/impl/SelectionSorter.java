package best.project.lore.algorithms.sort.impl;

import best.project.lore.algorithms.sort.ISorter;

//Time Complexity O(n²)
//Space Complexity O(l)
public class SelectionSorter implements ISorter {

	@Override
	public int[] sort(int[] arrayToSort) {
		long startTime = System.nanoTime();
		int cycleCount = 0;
		
		for(int i = 0; i < arrayToSort.length; i++) {
			int minIndex = i;
			
			for(int j = i+1; j < arrayToSort.length;j++) {
				cycleCount++;
				if(arrayToSort[j] < arrayToSort[minIndex]) {
					minIndex = j;
				}
			}
			swap(arrayToSort, i, minIndex);
		}
		System.out.println("Cycle count = " + cycleCount);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Duration = " + duration);
		return arrayToSort;
	}
	
	private void swap(int[] arrayToSort, int highestIndex, int lowestIntex) {
		int tmp = arrayToSort[lowestIntex];
		arrayToSort[lowestIntex] = arrayToSort[highestIndex];
		arrayToSort[highestIndex] = tmp;
	}


}
