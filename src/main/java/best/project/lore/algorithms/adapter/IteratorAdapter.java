package best.project.lore.algorithms.adapter;

import java.util.Iterator;

public class IteratorAdapter {
	
	public IteratorAdapter() {
		//
	}
	
	public static <T> Iterator<T> flatten(Iterator<Iterator<T>> iterator) {
        return new Iterator<T>() {

        	private Iterator<T> iteratorInternal = new Iterator<T>(){

				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public T next() {
					return null;
				}
        		
        	};
        	
			@Override
			public boolean hasNext() {
				if(iterator.hasNext() && !iteratorInternal.hasNext()) {
					iteratorInternal = iterator.next();
				}
				return iteratorInternal.hasNext();
			}

			@Override
			public T next() {	
				return iteratorInternal.next();
			}
		};
    }

}
