package best.project.lore.algorithms.search.impl;

import best.project.lore.algorithms.search.ISearcher;

public class BinarySearcher implements ISearcher {

	@Override
	public int findPosition(int value, int[] intArray) {
		long startTime = System.nanoTime();
		
		int cycleCount = 0;
		int valuePosition = -1;
		int lowerBound = 0;
		int upperBound = intArray.length-1;

		while(lowerBound <= upperBound) {
			cycleCount++;
			if(value == intArray[lowerBound]) {
				valuePosition = lowerBound;
				break;
			}
			if(value == intArray[upperBound]) {
				valuePosition = upperBound;
				break;
			}
			
			int middleBound = (upperBound + lowerBound) / 2;
			
			if(value == intArray[middleBound]) {
				valuePosition = middleBound;
				break;
			}
			if(value > intArray[middleBound]) {
				lowerBound = middleBound + 1;
			} else {
				upperBound = middleBound - 1;
			}
		}
		System.out.println("Cycle count = " + cycleCount);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Duration = " + duration);
		return valuePosition;
	}

}
