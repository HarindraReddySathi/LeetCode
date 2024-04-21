class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rows[i] += (grid[i][j]==0) ?-1:1;
                cols[j] += (grid[i][j]==0) ?-1:1;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=rows[i]+cols[j];
            }
        }
        return grid;
    }
}