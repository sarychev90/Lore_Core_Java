package best.project.lore.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import best.project.lore.algorithms.search.impl.BinarySearcher;
import best.project.lore.algorithms.utils.IntArrayConverter;

class BinarySearchTest {
	
	@ParameterizedTest
    @CsvFileSource(resources = "/search.csv", numLinesToSkip = 1, delimiterString = ";")
	void findPositionTestFromFile(@ConvertWith(IntArrayConverter.class) int[] array, int value, int valuePosition){
		ISearcher searcher = new BinarySearcher();
		assertEquals(valuePosition, searcher.findPosition(value, array));
	}

}
