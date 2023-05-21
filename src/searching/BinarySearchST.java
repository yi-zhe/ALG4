package searching;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    private static final int INIT_CAPACITY = 2;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (value == null) {
            deleteKey(key);
            return;
        }

        int i = rank(key);

        // key is already in table
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        // insert new key-value pair
        if (N == keys.length) resize(2 * keys.length);

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return values[i];
        else return null;
    }

    @Override
    public void deleteKey(Key key) {
        if (isEmpty()) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < N - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        N--;
        keys[N] = null;  // to avoid loitering
        values[N] = null;

        // resize if 1/4 full
        if (N > 0 && N == keys.length / 4) resize(keys.length / 2);

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize(int capacity) {
        assert capacity >= N;
        Key[] tempk = (Key[]) new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N - 1];
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    @Override
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public void deleteMin() {
        deleteKey(min());
    }

    @Override
    public void deleteMax() {
        deleteKey(max());
    }

    @Override
    public int size(Key low, Key high) {
        if (low.compareTo(high) > 0) return 0;
        if (contains(high)) return rank(high) - rank(low) + 1;
        else return rank(high) - rank(low);
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        Queue<Key> q = new Queue<>();
        for (int i = rank(low); i < rank(high); i++) {
            q.enqueue(keys[i]);
        }
        if (contains(high)) {
            q.enqueue(keys[rank(high)]);
        }
        return q;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        String[] keys = {"z", "a", "d", "b", "c", "p", "q"};
        for (int i = 0; i < keys.length; i++) {
            st.put(keys[i], i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
