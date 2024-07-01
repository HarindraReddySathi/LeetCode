import java.util.*;

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ans = 0;
        int totalEdges = edges.length;

        // Initialize union-find arrays for Alice and Bob
        int[] parentA = new int[n + 1];
        int[] sizeA = new int[n + 1];
        int[] parentB = new int[n + 1];
        int[] sizeB = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parentA[i] = i;
            parentB[i] = i;
            sizeA[i] = 1;
            sizeB[i] = 1;
        }

        // Process type 3 edges (usable by both Alice and Bob)
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!union(edge[1], edge[2], parentA, sizeA)) {
                    ans++;
                } else {
                    union(edge[1], edge[2], parentB, sizeB);
                }
            }
        }

        // Process type 1 edges (usable by Alice)
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!union(edge[1], edge[2], parentA, sizeA)) {
                    ans++;
                }
            }
        }

        // Process type 2 edges (usable by Bob)
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (!union(edge[1], edge[2], parentB, sizeB)) {
                    ans++;
                }
            }
        }

        // Check if both Alice and Bob can traverse the entire graph
        if (getCount(parentA) != 1 || getCount(parentB) != 1) {
            return -1;
        }

        return ans;
    }

    private boolean union(int u, int v, int[] parent, int[] size) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);

        if (rootU == rootV) {
            return false;
        }

        if (size[rootU] >= size[rootV]) {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        } else {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        }

        return true;
    }

    private int find(int u, int[] parent) {
        if (parent[u] != u) {
            parent[u] = find(parent[u], parent); // Path compression
        }
        return parent[u];
    }

    private int getCount(int[] parent) {
        int count = 0;
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }
}
