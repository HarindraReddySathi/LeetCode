class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

        boolean[][] A = new boolean[n][n];
        for(int[] d : dig) A[d[0]][d[1]] = true;

        int ans =0;
        for(int[] cur : artifacts){
            boolean dec = true;
            for(int j=cur[0];j<=cur[2];j++){
                for(int l=cur[1];l<=cur[3];l++){
                    if(!A[j][l]) dec = false;
                }
            }
            if(dec)ans++;
        }
        return ans;
    }
}