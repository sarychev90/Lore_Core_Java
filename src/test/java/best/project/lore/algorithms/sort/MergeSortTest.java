package best.project.lore.algorithms.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import best.project.lore.algorithms.sort.impl.MergeSorter;
import best.project.lore.algorithms.utils.IntArrayConverter;
import best.project.lore.algorithms.utils.SortUtils;

class MergeSortTest {
	
	@ParameterizedTest
    @CsvFileSource(resources = "/sort.csv", numLinesToSkip = 1, delimiterString = ";")
	void sortTestFromFile(@ConvertWith(IntArrayConverter.class) int[] arrayToSort){
		SortUtils.printArray(arrayToSort);
		ISorter sorter = new MergeSorter();
		int[] arraySorted = sorter.sort(arrayToSort);
		SortUtils.printArray(arraySorted);
		assertTrue(SortUtils.isSorted(arraySorted));
	}
	
	@Test
	void sortTestArrayGenerated(){
		int[] arrayToSort = IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();
		SortUtils.printArray(arrayToSort);
		ISorter sorter = new MergeSorter();
		int[] arraySorted = sorter.sort(arrayToSort);
		SortUtils.printArray(arraySorted);
		assertTrue(SortUtils.isSorted(arraySorted));
	}

}
