package company.linkedin;

import java.util.*;

interface Rankable {
  /**
   * Returns the Rank of this object, using some algorithm and potentially the internal state of the
   * Rankable.
   */
  long getRank();
}

// What if rank is defined as number of reads of element in cache?
// LRU
// Let's assume that rank can change dynamicly. It is not immutable, but it is not LRU. We do not
// know how it is changed

/*‍‌‌‌‌‌‌‍‍‌‍‍‍‍‌‍‍‍‍‌
 * For reference, here are the Rankable and DataSource interfaces.
 * You do not need to implement them, and should not make assumptions
 * about their implementations.
 */

interface DataSource<K, T extends Rankable> {
  T get(K key);
}

public class RetainBestCache<K, T extends Rankable> {

  private final Map<K, T> cache;
  private final Map<Long, Set<K>> rankingOfObject;
  private final DataSource<K, T> dataSource;
  private final int maxSizeOfCache;

  /* Constructor with a data source (assumed to be slow) and a cache size */
  public RetainBestCache(DataSource<K, T> ds, int entriesToRetain) {
    // Implementation here
    cache = new HashMap<>();
    rankingOfObject = new TreeMap<>();
    dataSource = ds;
    maxSizeOfCache = entriesToRetain;
  }

  /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
   * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
   * evicting the T with the lowest rank among the ones that it has available
   * If there is a tie, the cache may choose any T with the lowest rank to evict.
   */
  public T get(K key) {
    // Implementation here
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    return fetchDataFromDs(key);
  }

  private T fetchDataFromDs(K key) {
    if (cache.size() >= maxSizeOfCache) {
      evictElement();
    }
    T object = dataSource.get(key);
    cache.put(key, object);
    long rankOfObject = object.getRank();
    if (!rankingOfObject.containsKey(rankOfObject)) {
      rankingOfObject.put(rankOfObject, new HashSet<>());
    }
    rankingOfObject.get(rankOfObject).add(key);
    return object;
  }

  private void evictElement() {
    //    Map.Entry<Long, Set<K>> entry = rankingOfObject.topEntry();
    Map.Entry<Long, Set<K>> entry = rankingOfObject.entrySet().iterator().next();
    K key = entry.getValue().iterator().next();
    entry.getValue().remove(key);
    cache.remove(key);
    if (entry.getValue().size() == 0) {
      rankingOfObject.remove(entry.getKey());
    }
  }
}
