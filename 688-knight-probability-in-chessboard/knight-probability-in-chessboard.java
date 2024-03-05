class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        // calculate the probability of each cell at each level
        //TC-O(k*N^2) SC(k*N^2)
        if (k == 0) return 1.0;
        int[][] dir = {{1,2},{-1,2},{2,1},{2,-1},{1,-2},{-2,-1},{-1,-2},{-2,1}};
        double[][] curmemo = new double[n][n];
        double[][] prememo = new double[n][n];
        prememo[row][column] = 1.0;

        for (int move = 1; move <= k; move++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double present = 0.0;
                    for (int d = 0; d < 8; d++) {
                        int x = i + dir[d][0];
                        int y = j + dir[d][1];
                        if (x >= 0 && y >= 0 && x < n && y < n) {
                            present += prememo[x][y];
                        }
                    }
                    curmemo[i][j] = present / 8.0;
                }
            }
            prememo=curmemo;
            curmemo = new double[n][n];
        }

        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += prememo[i][j];
            }
        }                 
        return ans;
    }
}