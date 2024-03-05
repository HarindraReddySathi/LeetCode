class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] memo = new int[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j =0;j<n;j++){
                if(i==n-1)memo[i][j]=matrix[i][j];
                else if(j==0)memo[i][j]=matrix[i][j]+Math.min(memo[i+1][j],memo[i+1][j+1]);
                else if(j==n-1)memo[i][j]=matrix[i][j]+Math.min(memo[i+1][j],memo[i+1][j-1]);
                else memo[i][j]=matrix[i][j]+Math.min(Math.min(memo[i+1][j],memo[i+1][j-1]),memo[i+1][j+1]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j =0;j<n;j++){
            ans= Math.min(ans,memo[0][j]);
        }
        return ans;
    }
}