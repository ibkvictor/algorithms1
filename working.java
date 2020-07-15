import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;

public class working {
    public static void main(String[] args) {
        Integer[] a = { 5, 5, 6, 7, 3, 7, 3, 5, 6, 10 };
        Insertion.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}