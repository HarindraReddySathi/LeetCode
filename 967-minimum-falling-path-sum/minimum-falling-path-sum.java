class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        if(n==1) return matrix[0][0];
        for(int i=n-2;i>=0;i--){
            ans = Integer.MAX_VALUE;
            for(int j =0;j<n;j++){
                if(j==0)matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                else if(j==n-1)matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                else matrix[i][j]+=Math.min(Math.min(matrix[i+1][j],matrix[i+1][j-1]),matrix[i+1][j+1]);
                ans= Math.min(ans,matrix[i][j]);
            }
        }
        return ans;
    }
}