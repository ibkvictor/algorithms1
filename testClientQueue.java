public class testClientQueue {
    private node first,last;
    testClientQueue () {
        first = last = null;
    }
    public boolean isEmpty() {
        return last == null;
    }

    public class node {
        String item; 
        node next; 
    }
    public void enqueue(String str) {
        node oldlast = last;
        last.item = str;
        last.next = oldlast;
    }
    public String dequeue() {
        node oldfirst = first;
        first = first.next;
        return oldfirst.item;
        // oldfirst = null;
    }
    public static void main(String[] args) {
        
    }
}