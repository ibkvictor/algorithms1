import edu.princeton.cs.algs4.StdOut;

public class testClientQueueArray {
    String[] s;
    int n;
    testClientQueueArray(){
        int size = 2;
        s = new String[size];
        n = 0;
    }
    public boolean isEmpty() {
        return s[n] == null;
    }
    public void enqueue(String str) {
        try {
            s[n++] = str;
        } catch (Exception e) {
            String[] copy = new String[2*s.length];
            for (int i = 0; i <= n; i++) {
                copy[i] = s[i];
            }
            s = copy;
            enqueue (str);
        }
    }
    public String dequeue() {
       if (n<(s.length / 4) + 1) {
            String[] copy = new String[s.length/4];
            for (int i = 0; i <= n; i++) {
                copy[i] = s[i];
            }
            s = copy;
            return dequeue();
       }
       else return s[--n];
    }
    public static void main(String[] args) {
        int i = 0;
        testClientQueueArray queue = new testClientQueueArray();
        while (i < args.length){
            String stri = args[i];
            if (stri.equals("-")) StdOut.print(queue.dequeue()+ ", ");
            else queue.enqueue(stri);
            i++;
        }

    }
}