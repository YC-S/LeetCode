package leetcode500.p31_iterator.plan1;

import java.util.Iterator;

public class P284_PeekingIterator implements Iterator<Integer> {
  private final Iterator<Integer> iterator;
  private Integer next = null;

  public P284_PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator = iterator;
    if (this.iterator.hasNext()) next = this.iterator.next();
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return next;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    Integer res = next;
    next = iterator.hasNext() ? iterator.next() : null;
    return res;
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }
}
