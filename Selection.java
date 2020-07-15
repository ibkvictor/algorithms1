import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;

public class Selection {
    public void sort (Comparable[] a){
        for (int i = 0; i< a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(less(a[j], a[i]))
                    exch(a[i], a[j]);
            }
        }
    }
    public boolean less(Comparable a, Comparable b) {
        if(a.compareTo(b) == -1) 
            return true;
        else
            return false;
    }
    public void exch(Comparable a, Comparable b) {
        Comparable swap = a;
        a = b;
        b = swap;
    }
    public static void main(String[] args) {
        Selection baby = new Selection();
        Integer[] a = { 5, 5, 6, 7, 3, 7, 3, 5, 6, 10 };
        baby.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}