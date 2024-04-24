class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int temp = DFS(grid,i,j,m,n);
                    if(temp>max)max = temp;
                }
            }
        }
        return max;
    }

    public int DFS(int[][] grid,int i,int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==-1 || grid[i][j]==0) return 0;
        grid[i][j]=-1;
        /*int count=1;
        count+=DFS(grid,i+1,j,m,n);
        count+=DFS(grid,i-1,j,m,n);
        count+=DFS(grid,i,j+1,m,n);
        count+=DFS(grid,i,j-1,m,n);
        return count;*/
        return 1+DFS(grid,i+1,j,m,n)+DFS(grid,i-1,j,m,n)+DFS(grid,i,j+1,m,n)+DFS(grid,i,j-1,m,n);
    }
}