class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int numOfIslands =0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    numOfIslands++;
                    BFS(i, j, grid,m,n);
                }
            }
        }

        return numOfIslands;
    }

    public void BFS(int i,int j,char[][] grid,int m,int n){

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> traverse = new LinkedList<>();
        traverse.add(new int[]{i,j});
        grid[i][j]='0';

        while(!traverse.isEmpty()){
            int[] current = traverse.poll();
            for(int[] direction : directions){
                int x = current[0]+direction[0];
                int y = current[1]+direction[1];
                if(x>=0 && y>=0 && x<m && y<n && grid[x][y]=='1'){
                    traverse.add(new int[]{x,y});
                    grid[x][y]='0';
                }
            }
        }
    }
}