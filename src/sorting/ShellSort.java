package sorting;

import static utils.SortUtils.*;

public class ShellSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = N / 2;
        while (h != 0) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 2;
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {2, 3, 4, 1, 6};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
