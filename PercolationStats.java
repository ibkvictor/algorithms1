import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class PercolationStats {
    // Percolation network properties;
    // Percolation [] nt;
    private final int trialNumber;
    private final double threshold [];
    private final double value = 1.96;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if(n<0 || trials<0) throw new IllegalArgumentException("illegal declaration for trails or grid size");
        trialNumber = trials;
        threshold = new double [trialNumber];
        // nt = new Percolation(n) [trialNumber];
        // network = new Percolation(grid_size);
    }
    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(threshold);
    }
    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(threshold);
    }
    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        return (mean()-(value*(stddev()/Math.sqrt(trialNumber))));
    }
    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return (mean()+(value*(stddev()/Math.sqrt(trialNumber))));
    }
   // test client (see below)
   public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        if(n<=0||T<=0) throw new IllegalArgumentException("your number of trials or grid_size is wrong");
        // int n = 100;
        // int T = 1;
        PercolationStats p_network = new PercolationStats(n, T);
        int counter =0;
        while(counter <T) {
            Percolation network = new Percolation(n);
            while (network.percolates()==false) {
                network.open((int) (StdRandom.uniform()*n+1),(int) (StdRandom.uniform()*n+1));
            }
            p_network.threshold[counter] =(double) network.numberOfOpenSites()/(double)(n*n);
            StdOut.println(network.numberOfOpenSites());
            StdOut.println(p_network.threshold[counter]);
            counter++;
        }
        StdOut.print(
            "mean                           ="+p_network.mean()+"\n" +
            "stddev                         ="+p_network.stddev()+"\n" +
            "95% confidence interval        ="+"["+p_network.confidenceLo()+","+p_network.confidenceHi()+"]"
        );
   }
}