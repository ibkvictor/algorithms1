import edu.princeton.cs.algs4.StdOut;

public class dutch_national_flag_3_way_partition {
    public void swap(int a, int b){
        int swap = a;
        a = b;
        b = swap;
    }
    public static void main(String[] args) {
        dutch_national_flag_3_way_partition dutch = new dutch_national_flag_3_way_partition();
        int [] a = {0,2,2,1,1,0,2,1,0,1};
        // StdOut.println(a.length);
        // int high = (a.length - 1);
        int high = 9;
        int low = 0;
        int mid = 0;
        while (mid <= (a.length-1)) {
            switch (a[mid]) {
                case 0:{
                    dutch.swap(a[mid], a[low]);
                    mid ++;
                    low ++;
                    break;
                }
                case 1:{
                    mid ++;
                    break
                }
                case 2:{
                    dutch.swap(a[mid], a[high]);
                    high -- ;
                    break;
                }
            }
            // if(a[mid] == 0){
            //     swap(a[mid], a[low]);
            //     mid ++;
            //     low ++;
            // }
            // else if(a[mid] == 1){
            //     mid ++;
            //     break;
            // }
            // else {
            //     swap(a[mid], a[high]);
            //     // StdOut.println(high);
            //     high -- ;
            //     break;
            // }
        }
        for (int j = 0; j < a.length; j++) {
            StdOut.println(a[j]);
        }
    }
}