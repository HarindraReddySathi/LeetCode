class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] check = new boolean[m][n];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int temp = DFS(grid,check,i,j,m,n);
                    if(temp>max)max = temp;
                }
            }
        }
        return max;
    }

    public int DFS(int[][] grid,boolean[][] check,int i,int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==-1 || grid[i][j]==0) return 0;
        grid[i][j]=-1;
        //check[i][j]=true;
        int count=1;
        count+=DFS(grid,check,i+1,j,m,n);
        count+=DFS(grid,check,i-1,j,m,n);
        count+=DFS(grid,check,i,j+1,m,n);
        count+=DFS(grid,check,i,j-1,m,n);
        return count;
    }
}