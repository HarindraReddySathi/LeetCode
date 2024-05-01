class Solution {
    public int matrixScore(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int ans =0,cur=1;
        for(int j = n-1;j>0;j--){
            int[] dec = new int[2];
            for(int i =0;i<m;i++){
                if(grid[i][0]==1){
                    dec[grid[i][j]]++;
                }else{
                    int t = (grid[i][j]==0) ? 1:0;
                    dec[t]++;
                }
            }
            int mul = (dec[0]>dec[1]) ? dec[0] : dec[1];
            ans+=(cur*mul);
            cur = cur<<1;
        }
        return ans+(cur*m);
    }
}