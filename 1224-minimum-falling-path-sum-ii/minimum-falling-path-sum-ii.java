class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int ans = Integer.MAX_VALUE;
        for(int i =0;i<m;i++){
            for(int j =0;j<m;j++){
                if(i!=0){
                    int min = Integer.MAX_VALUE;
                    for(int k=0;k<m;k++){
                        if(j==k) continue;
                        if(grid[i-1][k]<min) min = grid[i-1][k];
                    }
                    grid[i][j]+=min;
                }
                if(i==m-1 && grid[i][j]<ans) ans = grid[i][j];
            }
        }
        return ans;
    }
}