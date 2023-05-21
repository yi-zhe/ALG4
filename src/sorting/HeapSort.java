package sorting;

import static utils.SortUtils.isSorted;
import static utils.SortUtils.show;

public class HeapSort {

    public static void sort(Comparable[] a) {
        
    }

    public static void main(String[] args) {
        Comparable[] a = {2, 3, 4, 1, 6};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
