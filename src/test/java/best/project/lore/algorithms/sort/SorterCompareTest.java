package best.project.lore.algorithms.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import best.project.lore.algorithms.utils.IntArrayConverter;
import best.project.lore.algorithms.utils.SortUtils;

class SorterCompareTest {
	
	private static final String SORTER_PKG = "best.project.lore.algorithms.sort.impl.";
	
	@ParameterizedTest
    @CsvFileSource(resources = "/sort_compare.csv", numLinesToSkip = 1, delimiterString = ";")
	void sortTestFromFile(@ConvertWith(IntArrayConverter.class) int[] arrayToSort, String className) throws Exception {
		Class<?> sorterClass = Class.forName(SORTER_PKG + className);
		ISorter sorter = (ISorter) sorterClass.getDeclaredConstructor().newInstance();
		System.out.println("Sorter = " + sorterClass.getSimpleName());
		int[] arraySorted = sorter.sort(arrayToSort);
		SortUtils.printArray(arraySorted);
		assertTrue(SortUtils.isSorted(arraySorted));
	}
	
	@ParameterizedTest
	@CsvSource({"BubbleSorter", "InsertionSorter","QuickSorter", "MergeSorter", "SelectionSorter"})
	void sortTestArrayGenerated(String className) throws Exception {
		int[] arrayToSort = IntStream.generate(() -> new Random().nextInt(100)).limit(1000).toArray();
		Class<?> sorterClass = Class.forName(SORTER_PKG + className);
		ISorter sorter = (ISorter) sorterClass.getDeclaredConstructor().newInstance();
		System.out.println("Sorter = " + sorterClass.getSimpleName());
		int[] arraySorted = sorter.sort(arrayToSort);
		SortUtils.printArray(arraySorted);
		assertTrue(SortUtils.isSorted(arraySorted));
	}

}
