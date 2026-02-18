import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    boolean[][] land = null;
    WeightedQuickUnionUF lan = null;
    WeightedQuickUnionUF lany = null;
    int S;
    int size;
    public Percolation(int N) {
        if (N < 0) {
            throw new  java.lang.IllegalArgumentException("N必须大于0");
        }
        land = new boolean[N+1][N+1];
        for (int i = 0;i <= N;i++) {
            for (int j = 0;j <= N;j++) {
                land[i][j] = false;
            }
        }
        S = N;
        size = 0;
        lan = new WeightedQuickUnionUF((N+1) * (N+1));
        lany = new WeightedQuickUnionUF((N+1) * (N+1));
        for (int i = 0;i < S;i++) {
            lany.union(translate(S,1),translate(S-1,i));
        }
    }

    public void open(int row, int col) {
        if (row < 0||col > S-1||row>S-1||col < 0) {
            throw new  java.lang.IllegalArgumentException("越界了");
        }
        if (land[row][col] == true) {
            return;
        }
        land[row][col] = true;
        size++;
        if (row == 0) {
            lan.union(translate(row,col),translate(S,0));
            lany.union(translate(row,col),translate(S,0));
        }
        if (row+1 < S&&isOpen(row+1,col)) {
            lan.union(translate(row,col),translate(row+1,col));
            lany.union(translate(row,col),translate(row+1,col));
        }
        if (row-1 >= 0&&isOpen(row-1,col)) {
            lan.union(translate(row,col),translate(row-1,col));
            lany.union(translate(row,col),translate(row-1,col));
        }
        if (col+1 < S&&isOpen(row,col+1)) {
            lan.union(translate(row,col),translate(row,col+1));
            lany.union(translate(row,col),translate(row,col+1));
        }
        if (col-1 >= 0&&isOpen(row,col-1)) {
            lan.union(translate(row,col),translate(row,col-1));
            lany.union(translate(row,col),translate(row,col-1));
        }
        if (row == S-1) {
            if (lan.connected(translate(S,0),translate(row,col))) {
                lan.union(translate(row,col),translate(S,1));
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (row < 0||col > S-1||row>S-1||col < 0) {
            throw new  java.lang.IllegalArgumentException("越界了");
        }
        if (land[row][col] == true) {
            return true;
        }
        return false;
    }

    public boolean isFull(int row, int col) {
        if (row < 0||col > S-1||row>S-1||col < 0) {
            throw new  java.lang.IllegalArgumentException("越界了");
        }
        if (lan.connected(translate(S,0),translate(row,col))) {
            return true;
        }
        return false;
    }

    public int numberOfOpenSites() {
        return size;
    }

    public boolean percolates() {
        if (lany.connected(translate(S,0),translate(S,1))) {
            return true;
        }
        return false;
    }


    // TODO: Add any useful helper methods (we highly recommend this!).
    int translate(int a,int b) {
        return a*S+b;
    }
    // TODO: Remove all TODO comments before submitting.

}
