class Solution {
    public int findChampion(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            boolean dec = true;
            for(int j=0;j<n;j++){
                if(i!=j && grid[i][j]==0){
                    dec = false;
                    break;
                }
            }
            if(dec) return i;
        }
        return -1;
    }
}