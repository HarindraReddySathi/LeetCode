class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        int[][] result;
        if(m*n == original.length){
            result = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    result[i][j] = original[i*n+j];
                }
            }
        }else{
            result = new int[0][0];;
        }
        return result;
    }
}