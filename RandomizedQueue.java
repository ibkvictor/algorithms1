import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
public class RandomizedQueue <Item>  implements Iterable <Item>  {
    private int front;
    private int back;
    private Item[] array;
    // construct an empty randomized queue
    public RandomizedQueue() {
        array = (Item[]) new Object[2];
        front=back=0;
    }
    // is the randomized queue empty?
    public boolean isEmpty() {
        return (back-front) == 0;
    }
    // return the number of items on the randomized queue
    public int size() {
        return back-front;
    }
    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("you are adding a null item");
        if ((back - front) == array.length) {
            Item[] copy = (Item[]) new Object[array.length * 2];
            for (int i = 0, j = front; i < back - front; i++, j++) {
                copy[i] = array[j];
            }
            array = copy;
            back = back - front;
            front = 0;
        }
        // if (isEmpty()) {
            array[back++] = item;
        // }
        // else {
        //     int index = (int) (StdRandom.uniform(size())+front);
        //     StdOut.println("the indices"+index);
        //     Item holder = array[index];
        //     array[back++] = holder;
        //     array[index] = item;
        // }
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("the list is empty");
        if (back > 0 && back == (int) (array.length * 0.25)) {
            final Item[] copy = (Item[]) new Object[(int) (array.length * 0.5)];
            for (int i = 0, j = front; i < back - front; i++, j++) {
                copy[i] = array[j];
            }
            array = copy;
            back = back - front;
            front = 0;
            // StdOut.println("here come the deque");
            // for (int i = 0; i < array.length; i++) {
            //     StdOut.println(array[i]);
            // }
        }

        int index = (int) (StdRandom.uniform() * ((size()-1)+front));
        Item holder = array[index];
        array[index] = array[front];
        array[front] = null;
        front++;
        return holder;
    }
    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("the list is empty");
        return iterator().next();
    }
    private class MyIterator implements Iterator <Item>  {
        private int monitor;
        private int[] StorageIndex;
        private int n;
        MyIterator() {
            n = front;
            monitor = 0;
            StorageIndex = new int[size()];
            for (int i = 0; i < StorageIndex.length; i++) {
                StorageIndex[i] = n++;
            }
            StdRandom.shuffle(StorageIndex);
            // StdOut.println("StorageIndex");
            // for (int i = 0; i < size(); i++) {
            //     StdOut.println(StorageIndex[i]);
            // }
            // StdOut.println("StorageIndex end");
            // StdOut.println("array");
            // for (int i = 0; i < back; i++) {
            //     StdOut.println(array[i]);
            // }
            // StdOut.println("array end");
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException("you tried to call remove");
        }
        @Override
        public boolean hasNext() {
            if (monitor>=size()) {
                return false;
            }
            return  (array[StorageIndex[monitor]]!= null);
        }

        @Override
        public Item next() {
            if (isEmpty() || monitor>= size()) {
                throw new NoSuchElementException();
            }
            else{
                int var = monitor;
                monitor++;
                return array[StorageIndex[var]];
            }
        }
    }
    // return an independent iterator over items in random order
    public Iterator <Item> iterator() {
        return new MyIterator();
    }
    // unit testing (required)
    public static void main(final String[] args) {
        final RandomizedQueue <Integer>  randQueue = new RandomizedQueue <Integer>  ();
        randQueue.enqueue(1);
        randQueue.enqueue(2);
        randQueue.enqueue(3);
        randQueue.enqueue(4);
        randQueue.enqueue(5);
        StdOut.println("the dequeue phase");
        StdOut.println(randQueue.dequeue());
        StdOut.println(randQueue.dequeue());
        randQueue.enqueue(8);
        randQueue.enqueue(9);
        StdOut.println(randQueue.size());
        final Iterator <Integer>  iteration = randQueue.iterator();
        final Iterator <Integer>  iteration2 = randQueue.iterator();
        StdOut.println(randQueue.sample());
        StdOut.println("iterator");
        while(iteration.hasNext()==true){
            StdOut.println(iteration.next());
        }
        StdOut.println("iterator");
        while(iteration2.hasNext()==true){
            StdOut.println(iteration2.next());
        }
    }
}