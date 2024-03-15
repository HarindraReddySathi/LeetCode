class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] matrix = new int[n][n];
        int p = queries.length;
        for(int i=0;i<p;i++){
            int i1 = queries[i][0];
            int j1 = queries[i][1];
            int i2 = queries[i][2];
            int j2 = queries[i][3];
            for(int x =i1;x<=i2;x++){
                matrix[x][j2]++;
                if(j1!=0)matrix[x][j1-1]--;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=n-2;j>=0;j--){
                matrix[i][j]+=matrix[i][j+1];
            }
        }
        return matrix;
    }
}