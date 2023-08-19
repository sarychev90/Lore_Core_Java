package best.project.lore.algorithms.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

class InteratorAdapterTest {
	
	@Test
	void iteratorAdapterTest(){
		Iterator<Iterator<Integer>> it = Arrays.asList(Arrays.asList(1, 2).iterator(), Arrays.asList(3, 4).iterator()).iterator();
		Iterator<Integer> result = IteratorAdapter.flatten(it);
		int i = 0;
		while (result.hasNext()) {
			i++;
			assertEquals(i, result.next());
		}
		assertEquals(4,i);
	}

}
