package best.project.lore.algorithms.sort.impl;

import best.project.lore.algorithms.sort.ISorter;

//Time Complexity O(n) -> O(n²)
//Space Complexity O(l)
public class BubbleSorter implements ISorter {

	@Override
	public int[] sort(int[] arrayToSort) {
		long startTime = System.nanoTime();
		int cycleCount = 0;
		
		boolean isSortProvided = Boolean.TRUE;
		while(isSortProvided) {
			isSortProvided = Boolean.FALSE;
			for(int i = 0; i < arrayToSort.length-1; i++) {
				cycleCount++;
				if(arrayToSort[i] > arrayToSort[i+1]) {
					isSortProvided = Boolean.TRUE;
					int tmp = arrayToSort[i];
					arrayToSort[i] = arrayToSort[i+1];
					arrayToSort[i+1] = tmp;
				}
			}
		}
		
		System.out.println("Cycle count = " + cycleCount);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Duration = " + duration);
		return arrayToSort;
	}

}
