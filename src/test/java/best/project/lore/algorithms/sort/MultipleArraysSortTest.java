package best.project.lore.algorithms.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import best.project.lore.algorithms.sort.impl.MultipleArraysSorter;
import best.project.lore.algorithms.sort.impl.QuickSorter;
import best.project.lore.algorithms.utils.SortUtils;

class MultipleArraysSortTest {
	
	@Test
	void mergeTest() {
		int[] array1 = IntStream.generate(() -> new Random().nextInt(100)).limit(10).toArray();
		int[] array2 = IntStream.generate(() -> new Random().nextInt(100)).limit(5).toArray();
		SortUtils.printArray(array1);
		SortUtils.printArray(array2);
		MultipleArraysSorter sorter = new MultipleArraysSorter(new QuickSorter());
		int[] arrayMerged = sorter.merge(array1, array2);
		SortUtils.printArray(arrayMerged);
		assertEquals(array1.length+array2.length, arrayMerged.length);
		assertTrue(SortUtils.isSorted(arrayMerged));
	}

}
