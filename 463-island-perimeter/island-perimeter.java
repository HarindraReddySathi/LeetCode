class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int perimeter =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int[] k : dir){
                        int x = i+k[0];
                        int y = j+k[1];
                        if(x>=0 && y>=0 && x<m && y<n){
                            if(grid[x][y]==0) perimeter++;
                        }else{
                            perimeter++;
                        }
                    }
                }
            }
        }
        return perimeter;
    }
}