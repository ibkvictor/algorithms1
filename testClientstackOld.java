import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class testClientstackOld {
    
    int n = 0;
    String[] s;
    public String pop(){
        return this.s[n--];
    }
    public void push(String str){
        this.s[n++] = str;
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