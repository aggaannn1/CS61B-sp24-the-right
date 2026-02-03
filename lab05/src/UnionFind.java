public class UnionFind {
    // TODO: Instance variables
    int a[];
    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        // TODO: YOUR CODE HERE
        a = new int[N];
        for (int i = 0;i<N;i++) {
            a[i] = -1;
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        // TODO: YOUR CODE HERE

        return a[find(v)];
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        // TODO: YOUR CODE HERE
        return a[v];
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO: YOUR CODE HERE
        if (find(v1) == find(v2)) {
            return true;
        }
        return false;
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        // TODO: YOUR CODE HERE
        if (v >= a.length || v < 0) {
            throw new IllegalArgumentException("Some comment to describe the reason for throwing.");
        }
        int k = v;
        int c = v;
        while (a[k] >= 0) {
            k = a[k];
        }
        while (a[c] >= 0) {
            int b = c;
            c = a[c];
            a[b] = k;

        }
        return k;
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        // TODO: YOUR CODE HERE
        int m = find(v1);
        int n = find(v2);
        int t = a[m] + a[n];
        if (-a[m] <= -a[n]) {
             a[m] = n;
             a[n] = t;
        }else {
            a[n] = m;
            a[m] = t;
        }
        return;
    }

}
