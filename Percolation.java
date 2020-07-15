// import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int grid_type;
    private int count;
    private final WeightedQuickUnionUF unionFind;
    private boolean record_open[];
    private final int virtual_top;
    private final int virtual_bottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n<=0) throw new IllegalArgumentException("negative grid is out of bound");
        this.grid_type = n;
        this.count = 0;
        this.unionFind = new WeightedQuickUnionUF(n*n+2);
        this.record_open = new boolean [(n*n)+1];
        for (int b = 0; b < record_open.length; b++) {
            record_open[b] = false;
        }
        // for (boolean b : record_open) b = false;
        virtual_bottom =  n*n+1;
        virtual_top = 0;
    }
        // opens the site (row, col) if it is not open already
    public void open(int row, int column){
        int i = siteToIndex(row, column);
        if(isOpen(row, column)){
            return ;
        }
        else {
            if(column<grid_type && isOpen(row, column+1)==true) unionFind.union(i, i+1);
            if(row<grid_type && isOpen(row+1, column)==true) unionFind.union(i, i+grid_type);
            if (row == grid_type) unionFind.union(i, virtual_bottom);
            if(row>1 && isOpen(row-1, column)==true) unionFind.union(i, i-grid_type);
            if (row == 1) unionFind.union(i, virtual_top);
            if(column>1 && isOpen(row, column-1)==true) unionFind.union(i, i-1);
            count++;
            record_open[i] = true;
        }
    }
        // is the site (row, col) open?
    public boolean isOpen(int row,int column){
        int i = siteToIndex(row, column);
            if (record_open[i]==true) {
                return true;
            }
            else{
                return false;
            }
        }
        // is the site (row, col) full?
    public boolean isFull(int row,int column){
        int i = siteToIndex(row, column);
        if (unionFind.find(i)==unionFind.find(virtual_top)) {
            return true;
        } else {
            return false;
        }
        // returns the number of open sites
    }
    public int numberOfOpenSites(){
        return count;
    }
        // does the system percolate?
    public boolean percolates(){
        if (unionFind.find(virtual_top)==unionFind.find(virtual_bottom))return true;
        else return false;
    }
    private int siteToIndex(int row, int column) {
        if (row<1||row>grid_type||column<1||column>grid_type)   throw new IllegalArgumentException("Boundary of sites exceeded");
        else {
            int i = ((grid_type)*(row-1)+column);
            return i;
        }
    }
        // test client (optional)
    public static void main (String[] args){
        // Percolation p1 = new Percolation(5);
        // // p1.open(2,1);
        // // p1.open(3,1);
        // // p1.open(4,5);
        // while (p1.percolates()==false) {
        //     p1.open((int) (StdRandom.uniform()*5+1), (int) (StdRandom.uniform()*5+1));
        // }
        // // while (p1.percolates()==false) {
        // //     p1.open(StdRandom.uniform(1, 4),StdRandom.uniform(1, 4)) ;
        // // }
        // System.out.println(p1.numberOfOpenSites());
        // System.out.println(p1.percolates());

        // for (int k = 0; k < p1.record_open.length; k++) {
        //     System.out.println(p1.record_open[k]);
        //     System.out.println(p1.unionFind.find(k+1));
        // }
    }
}