package searching;

public interface ST<Key extends Comparable<Key>, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    void deleteKey(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    int rank(Key key);

    Key select(int k);

    void deleteMin();

    void deleteMax();

    int size(Key low, Key high);

    Iterable<Key> keys(Key low, Key high);

    Iterable<Key> keys();
}
