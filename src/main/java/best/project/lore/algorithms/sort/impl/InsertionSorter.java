package best.project.lore.algorithms.sort.impl;

import best.project.lore.algorithms.sort.ISorter;

//Time Complexity O(n) -> O(n²)
//Space Complexity O(l)
public class InsertionSorter implements ISorter {

	@Override
	public int[] sort(int[] arrayToSort) {
		long startTime = System.nanoTime();
		int cycleCount = 0;
		
		for(int i = 1; i < arrayToSort.length; i++) {
			int tmp = arrayToSort[i];
			
			int j = i-1;
			
			while(j >= 0 && arrayToSort[j] > tmp) {
				cycleCount++;
				arrayToSort[j+1] = arrayToSort[j];
				j--;
			}
			arrayToSort[j+1] = tmp;
		}
		
		System.out.println("Cycle count = " + cycleCount);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Duration = " + duration);
		return arrayToSort;
	}

}
