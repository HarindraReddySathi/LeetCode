class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

        int[][] A = new int[n][n];
        for(int[] d : dig) A[d[0]][d[1]] = 1;

        int ans =0;
        int k = artifacts.length;
        for(int i=0;i<k;i++){
            int r1 = artifacts[i][0];
            int c1 = artifacts[i][1];
            int r2 = artifacts[i][2];
            int c2 = artifacts[i][3];
            boolean dec = true;
            for(int j=r1;j<=r2;j++){
                for(int l=c1;l<=c2;l++){
                    if(A[j][l]==0){
                        dec = false;
                        break;
                    }
                }
                if(!dec) break;
            }
            if(dec)ans++;
        }
        return ans;
    }
}