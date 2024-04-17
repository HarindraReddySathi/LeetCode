class Solution {
    public int diagonalSum(int[][] mat) {
        int ans =0;
        int m = mat.length;
        for(int i=0;i<m;i++){
            ans+=mat[i][i];
            if(i!=(m-1-i))ans+=mat[i][m-1-i];
        }
        return ans;
    }
}