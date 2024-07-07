class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int subMatricesCount = 0;
        int[][][] state = new int[m][n][2];

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='X') state[i][j][0]++;
                else if(grid[i][j]=='Y') state[i][j][1]++;
                if(j!=0){
                    state[i][j][0] += state[i][j-1][0];
                    state[i][j][1] += state[i][j-1][1];
                }
            }
            for(int j=0;j<n;j++){
                if(i!=0){
                    state[i][j][0] += state[i-1][j][0];
                    state[i][j][1] += state[i-1][j][1];
                }
                if(state[i][j][0]!=0 && state[i][j][0] == state[i][j][1]){
                    subMatricesCount++;
                }
            }
        }
        return subMatricesCount;
    }
}