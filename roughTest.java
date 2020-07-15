import edu.princeton.cs.algs4.StdOut;

public class roughTest {
    int size;
    int pointer = 0;
    String[] s;

    roughTest(int n) {
        this.size = n;
        s = new String[n];
    }
    public boolean isEmpty(){
        return s[0] == null;
    }
    public String pop() {
        String item =  s[pointer--];
        s[pointer] = null;
        return item;
    }
    public void push(String str){
        s[++pointer] =  str;
    }
    public static void main(String[] args) {
        roughTest stackArray = new roughTest(10);
        int i = 0;
        while (i < args.length){
            String stri = args[i];
            if (stri.equals("-")) StdOut.print(stackArray.pop()+ ", ");
            else stackArray.push(stri);
            i++;
        }
    }
}