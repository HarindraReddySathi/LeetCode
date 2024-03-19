class Solution {
    public int totalNQueens(int n) {
        boolean[] up = new boolean[2 * n + 1];
        boolean[] down = new boolean[2 * n + 1];
        boolean[] y = new boolean[n];

        return queens(up, down, y, 0, n);
    }

    public int queens(boolean[] up, boolean[] down, boolean[] y, int level, int n) {
        if (level == n)
            return 1;
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (up[level + j] || down[n - level + j] || y[j])
                continue;
            up[level + j] = down[n - level + j] = y[j] = true;
            res += queens(up, down, y, level + 1, n);
            up[level + j] = down[n - level + j] = y[j] = false;
        }
        return res;
    }
}