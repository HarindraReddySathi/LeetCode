class Solution {
    public int minimumArea(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int[] start = new int[]{rows,cols};
        int[] end = new int[2];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0) continue;
                start[0] = Math.min(start[0],i);
                start[1] = Math.min(start[1],j);
                end[0] = Math.max(end[0],i);
                end[1] = Math.max(end[1],j);
            }
        }

        int maxArea = (end[0]-start[0]+1)*(end[1]-start[1]+1);
        return maxArea;
    }
}