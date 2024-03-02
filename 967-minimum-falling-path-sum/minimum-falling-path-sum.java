class Solution {
    public int minFallingPathSum(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){
                    mat[i][j]+=Math.min(mat[i+1][j+1],mat[i+1][j]);
                }else if(j==n-1){
                    mat[i][j]+=Math.min(mat[i+1][j-1],mat[i+1][j]);
                }else{
                    mat[i][j]+=Math.min(mat[i+1][j+1],Math.min(mat[i+1][j-1],mat[i+1][j]));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            if(mat[0][j]<ans)ans=mat[0][j];
        }
        return ans;
    }
}