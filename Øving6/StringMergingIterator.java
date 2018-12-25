package interfaces;

import java.util.Iterator;

public class StringMergingIterator {
	
	String s;
	
	private StringMergingIterator(Iterator<String> first, Iterator<String> second) {
		while (first.hasNext() && second.hasNext()) {
			s += first.next() + " ";
			s += second.next() + " ";
		}
	}
	
	private boolean hasNext() {
		return this.hasNext();
	}
	
	private String next() {
		return this.next();
	}
	
	
	
}
