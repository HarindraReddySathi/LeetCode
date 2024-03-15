class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] matrix = new int[n][n];
        int p = queries.length;
        for(int i=0;i<p;i++){
            int i1 = queries[i][0];
            int j1 = queries[i][1];
            int i2 = queries[i][2];
            int j2 = queries[i][3];
            for(int x = i1;x<=i2;x++){
                for(int y=j1;y<=j2;y++){
                    matrix[x][y]++;
                }
            }
        }
        return matrix;
    }
}