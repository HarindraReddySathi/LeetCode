class Solution {
    public double knightProbability(int n, int k, int row, int column) {

        if (k == 0) return 1.0;
        int[][] dir = {{1,2},{-1,2},{2,1},{2,-1},{1,-2},{-2,-1},{-1,-2},{-2,1}};
        double[][][] memo = new double[n][n][k + 1];
        memo[row][column][0] = 1.0;

        for (int move = 1; move <= k; move++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double present = 0.0;
                    for (int d = 0; d < 8; d++) {
                        int x = i + dir[d][0];
                        int y = j + dir[d][1];
                        if (x >= 0 && y >= 0 && x < n && y < n) {
                            present += memo[x][y][move - 1];
                        }
                    }
                    memo[i][j][move] = present / 8.0;
                }
            }
        }

        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += memo[i][j][k];
            }
        }                 
        return ans;
    }

    public void print(double[][][] memo,int k,int n){

        for(int l=0;l<=k;l++){
            System.out.println("********"+l+"******");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(memo[i][j][l]+"-");
                }
                System.out.println();
            }
        }
    }
}