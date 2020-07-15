import java.util.ArrayList;
import java.util.Collections;

import edu.princeton.cs.algs4.StdOut;

public class testClientarrayList {
    public static void main(String[] args) {
        ArrayList<Integer> AL = new ArrayList<Integer>();
        AL.add(5);
        AL.add(6);
        AL.add(7);
        StdOut.println(AL);
        StdOut.println(AL.get(0));
        AL.set(0, 9);
        StdOut.println(AL.get(0));
        AL.remove(1);
        StdOut.println("this is the new array" + AL);
        AL.add(8);
        AL.add(3);
        AL.add(2);
        Collections.sort(AL);
        StdOut.println("this is the new array" + AL);
        AL.clear();
        StdOut.print("this is the new array" + AL);
    }
}