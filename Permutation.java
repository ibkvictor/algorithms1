import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class Permutation{
    public static void main(final String[] args) {
        final RandomizedQueue<String> randomQueue = new RandomizedQueue<String>();
        final int p = Integer.parseInt(args[0]);
        while(!StdIn.isEmpty()) {
            randomQueue.enqueue(StdIn.readString());
        }
        for (int i = 0; i < p; i++) {
            StdOut.println(randomQueue.dequeue());
        }
    }
}