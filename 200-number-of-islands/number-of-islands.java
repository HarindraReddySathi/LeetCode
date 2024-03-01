class Solution {
    public int numIslands(char[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        int[][] isVisited = new int[m][n];
        int ans =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && isVisited[i][j]==0){
                    ans++;
                    DFS(grid,isVisited,i,j,m,n);
                }
            }
        }
        return ans;
    }

    public void DFS(char[][] grid,int[][] isVisited,int i,int j,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0' || isVisited[i][j]==1) return;
        isVisited[i][j]=1;
        DFS(grid,isVisited,i-1,j,m,n);
        DFS(grid,isVisited,i+1,j,m,n);
        DFS(grid,isVisited,i,j-1,m,n);
        DFS(grid,isVisited,i,j+1,m,n);
    }
}