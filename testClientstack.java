import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class testClientstack {
    public node first = null;
    public class node{
        String item;
        node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public String pop(){
        node toPop = first;
        first.next = first;
        return toPop.item;

    }
    public void push(String str){
        node oldfirst = first;
        first.item = str;
        first.next = oldfirst;
    }
    public static void main(String[] args) {
        testClientstack stack = new testClientstack();
        while (!StdIn.isEmpty()){
            String str = StdIn.readString();
            if (str.equals("-")) StdOut.print(stack.pop());
            else stack.push(str);
        }
    }
}