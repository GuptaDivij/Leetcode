// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Integer peekedElement;
    private Iterator<Integer> nativeIterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.nativeIterator=iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!hasNext()) return null;
        if(peekedElement!=null) return peekedElement;
        peekedElement=nativeIterator.next();
        return peekedElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(!hasNext()) return null;
	    if(peekedElement!=null) {
            Integer next = peekedElement;
            peekedElement = null;
            return next;
        }
        return nativeIterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    if(peekedElement!=null) return true;
        return nativeIterator.hasNext();
	}
}