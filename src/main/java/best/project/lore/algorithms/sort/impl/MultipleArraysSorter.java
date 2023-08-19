package best.project.lore.algorithms.sort.impl;

import best.project.lore.algorithms.sort.ISorter;
import best.project.lore.algorithms.utils.SortUtils;

public class MultipleArraysSorter {
	
	private ISorter sorter;
	
	public MultipleArraysSorter(ISorter sorter) {
		this.sorter = sorter;
	}

	public int[] merge(int[] array1, int[] array2) {
		int[] arrayMerged = new int[array1.length+array2.length];
		
		array1 = sorter.sort(array1);
		array2 = sorter.sort(array2);
		
		SortUtils.printArray(array1);
		SortUtils.printArray(array2);
		
		long startTime = System.nanoTime();
		
		int countElementArray1 = array1.length;
		int countElementArray2 = array2.length;
		
		for(int i = 0; i < arrayMerged.length; i++) {
			if(countElementArray1 > 0 && countElementArray2 > 0) {
				if(array1[array1.length - countElementArray1] < array2[array2.length - countElementArray2]) {
					arrayMerged[i] = array1[array1.length - countElementArray1];
					countElementArray1--;
				} else {
					arrayMerged[i] = array2[array2.length - countElementArray2];
					countElementArray2--;
				}
			} else if (countElementArray1 > 0){
				arrayMerged[i] = array1[array1.length - countElementArray1];
				countElementArray1--;
			} else if (countElementArray2 > 0) {
				arrayMerged[i] = array2[array2.length - countElementArray2];
				countElementArray2--;
			}
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Duration of merge = " + duration);
		return arrayMerged;
		
	}

}
