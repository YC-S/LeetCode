package company.apple;

import com.google.api.client.repackaged.com.google.common.base.Preconditions;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class NestedList implements Iterator<Integer> {
  private final List<List<Integer>> dataset;
  private final Iterator<List<Integer>> rowIterator;
  private Iterator<Integer> columnIterator;

  public NestedList(List<List<Integer>> dataset) {
    Preconditions.checkNotNull(dataset);
    this.dataset = dataset;
    this.rowIterator = dataset.iterator();
  }

  public static void main(String[] args) {}

  private boolean noDataInColumn() {
    return this.columnIterator == null || !this.columnIterator.hasNext();
  }

  @Override
  public boolean hasNext() {
    if (this.dataset.isEmpty()) return false;
    if (noDataInColumn()) return this.rowIterator.hasNext();
    return this.columnIterator.hasNext();
  }

  @Override
  public Integer next() {
    if (!hasNext()) throw new NoSuchElementException();
    if (noDataInColumn()) {
      this.columnIterator = this.rowIterator.next().iterator();
    }
    return this.columnIterator.next();
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("Not yet implemented");
  }
}
