class Solution {
    public long maxScore(int[] a, int[] b) {
        
        int n  = b.length;
        long[][] dp = new long[4][n];
        dp[0][0] = 1l*a[0]*b[0];
        for(int i =1;i<n;i++){
            dp[0][i] = Math.max(dp[0][i-1],1l*a[0]*b[i]);
        }
        dp[1][1] = dp[0][0]+1l*a[1]*b[1];
        for(int i=2;i<n;i++){
             dp[1][i] = Math.max(dp[1][i-1],1l*a[1]*b[i]+dp[0][i-1]);
        }
         dp[2][2] = dp[1][1]+1l*a[2]*b[2];
        for(int i=3;i<n;i++){
             dp[2][i] = Math.max(dp[2][i-1],1l*a[2]*b[i]+dp[1][i-1]);
        }
        dp[3][3] = dp[2][2]+1l*a[3]*b[3];
        for(int i=4;i<n;i++){
             dp[3][i] = Math.max(dp[3][i-1],1l*a[3]*b[i]+dp[2][i-1]);
        }
        return dp[3][n-1];
    }
}