class Solution {
    public int countServers(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int communicatableServers = 0;

        int[][] serverState = new int[rows][cols];

        for(int i =0;i<rows;i++){
            int serverCountRowWise =0;
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1)serverCountRowWise++;
                if(serverCountRowWise>1) break;
            }
            if(serverCountRowWise>1) {
                for(int j=0;j<cols;j++){
                    if(grid[i][j]==1){
                        serverState[i][j]=1;
                        communicatableServers++;
                    }
                }
            }
        }

        for(int j=0;j<cols;j++){
            int serverCountColumnWise =0;
            for(int i=0;i<rows;i++){
                if(grid[i][j]==1)serverCountColumnWise++;
                if(serverCountColumnWise>1) break;
            }
            if(serverCountColumnWise>1) {
                for(int i=0;i<rows;i++){
                    if(grid[i][j]==1 && serverState[i][j] != 1){
                        serverState[i][j]=1;
                        communicatableServers++;
                    }
                }
            }
        }

        return communicatableServers;
    }
}