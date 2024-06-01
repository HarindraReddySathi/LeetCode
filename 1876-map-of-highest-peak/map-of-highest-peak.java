class Solution {
    // 2.18
    public int[][] highestPeak(int[][] isWater) {
        
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int rows = isWater.length;
        int cols = isWater[0].length;

        int[][] heights = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(isWater[i][j]==1)queue.add(new int[]{i,j});
            }
        }
        int curHeight = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curLocation = queue.poll();
                for(int[] direction : directions){
                    int x = curLocation[0]+direction[0];
                    int y = curLocation[1]+direction[1];
                    if(x<0 || y<0 || x>=rows || y>=cols || isWater[x][y]==1 || heights[x][y]!=0) continue;
                    heights[x][y] = curHeight;
                    queue.add(new int[]{x,y});
                }
            }
            curHeight++;
        }
        return heights;
    }
}