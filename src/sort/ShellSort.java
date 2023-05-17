package sort;

import static utils.SortUtils.*;

public class ShellSort {

    public static void sort(Comparable[] a) {

    }

    public static void main(String[] args) {
        Comparable[] a = {2, 3, 4, 1, 6};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
