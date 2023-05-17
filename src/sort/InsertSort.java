package sort;

import static utils.SortUtils.*;

public class InsertSort {

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {2, 3, 4, 1, 6};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
