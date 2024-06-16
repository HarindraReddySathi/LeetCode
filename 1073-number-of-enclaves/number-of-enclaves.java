class Solution {
    public int numEnclaves(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans++;
                    if(i==0 || i == m-1 || j==0 || j==n-1)queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){

            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            if(grid[curX][curY]==0) continue;
            ans--;
            grid[curX][curY]=0;
            for(int[] direction : directions){
                int x = curX+direction[0];
                int y = curY+direction[1];
                if(x<0 || y<0 || x>=m || y>=n || grid[x][y]==0) continue;
                queue.add(new int[]{x,y});
            }
        }
        return ans;
    }
}