class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public void reverse(int[][] m){
        int n = m.length;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m.length/2;j++){
                int temp = m[i][j];
                m[i][j]=m[i][n-j-1];
                m[i][n-j-1]=temp;
            }
        }
    }

    public void transpose(int[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=i;j<m.length;j++){
                int temp = m[i][j];
                m[i][j]=m[j][i];
                m[j][i]=temp;
            }
        }
    }
}