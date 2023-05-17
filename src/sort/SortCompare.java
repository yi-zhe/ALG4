package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import utils.Stopwatch;

public class SortCompare {

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        // 算法1的总时间 
        double t2 = timeRandomInput(alg2, N, T);
        // 算法2的总时间
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniformDouble();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (InsertSort.class.getSimpleName().equals(alg)) InsertSort.sort(a);
        if (SelectSort.class.getSimpleName().equals(alg)) SelectSort.sort(a);
        if (ShellSort.class.getSimpleName().equals(alg)) ShellSort.sort(a);
        if (QuickSort.class.getSimpleName().equals(alg)) QuickSort.sort(a);
        if (MergeSort.class.getSimpleName().equals(alg)) MergeSort.sort(a);
        if (HeapSort.class.getSimpleName().equals(alg)) HeapSort.sort(a);
        return timer.elapsedTime();
    }
}
