package org.example._284.peeking.iterator;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private boolean peeked = false;
    private Integer peekedVal = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peeked) return peekedVal;

        peeked = true;
        peekedVal = iterator.next();
        return peekedVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peeked) {
            peeked = false;
            return peekedVal;
        }

        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (peeked) return true;

        return iterator.hasNext();
    }
}
