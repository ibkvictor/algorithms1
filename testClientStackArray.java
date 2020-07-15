import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class testClientStackArray {
    int size;
    int pointer = 0;
    String[] s;
    testClientStackArray(int n){
        this.size = n;
        s = new String[n];
    }
    public boolean isEmpty(){
        return s[0] == null;
    }
    public String pop(){
        String item = s[--pointer];
        s[pointer] = null;
        return item;
    }
    public void push(String str){
        s[pointer++] =  str;
    }
    public static void main(String[] args) {
        testClientStackArray stackArray = new testClientStackArray(10);
        while (!StdIn.isEmpty()){
            String stri = StdIn.readString();
            if (stri.equals("-")) StdOut.print(stackArray.pop());
            else stackArray.push(stri);
        }
    }
}