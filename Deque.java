import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
public class Deque<Item> implements Iterable<Item> {
    private int n = 0;
    private Node first, last;
    // construct an empty deque
    public Deque() {
        first = last = null;
    }
    // is the deque empty?
    private class Node{
        Item item;
        Node nextRight;
        Node nextLeft;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    // return the number of items on the deque
    public int size() {
        return n;
    }
    // add the item to the front
    public void addFirst(final Item element) {
        if (element == null)
            throw new IllegalArgumentException("you tried to add null");
        final Node oldfirst = first;
        first = new Node();
        first.item = element;
        first.nextRight = oldfirst;
        if (last != null) {
            first.nextRight.nextLeft = first;
        } else
            last = first;
        first.nextLeft = null;
        n++;
    }

    // add the item to the back
    public void addLast(final Item element) {
        if (element == null)
            throw new IllegalArgumentException("you tried to add null");
        final Node oldlast = last;
        last = new Node();
        last.item = element;
        last.nextLeft = oldlast;
        if (first != null) {
            last.nextLeft.nextRight = last;
        } else
            first = last;
        last.nextRight = null;
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("you tried to add null");
        Node oldfirst = first;
        Item item = oldfirst.item;
        first = first.nextRight;
        n--;
        oldfirst = null;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (n == 0)
            throw new NoSuchElementException("you tried to add null");
        Node oldlast = last;
        Item item = oldlast.item;
        last = last.nextLeft;
        n--;
        oldlast = null;
        return item;
    }

    private class DequeIterator implements Iterator<Item> {
        Node current;

        public DequeIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                final Item currentitem = current.item;
                current = current.nextRight;
                return currentitem;
            } else
                throw new NoSuchElementException("the deque doesn't have anymore items");
        }

        public void remove() {
            throw new UnsupportedOperationException("you tried to remove, it is illegal");
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(final String[] args) {
        final Deque<Integer> queue = new Deque <Integer> ();
        queue.addFirst(1);
        queue.addFirst(2);
        queue.addFirst(4);
        queue.addFirst(5);
        queue.addFirst(6);
        queue.addLast(4);
        StdOut.println(queue.first.item);
        StdOut.println(queue.first.nextRight.item);
        queue.removeFirst();
        StdOut.println(queue.first.item);
        queue.removeLast();
        StdOut.println(queue.last.item);
        StdOut.println(queue.last.nextLeft.item);
        final Iterator<Integer> iteration2 = queue.iterator();
        while (iteration2.hasNext()) {
            StdOut.println(iteration2.next());
        }
    }
}