class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        reverse(image);
        flip(image);
        return image;
    }

    public void flip(int[][] m ){
        int n = m.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                m[i][j]=m[i][j]^1;
            }
        }
    }

    public void reverse(int[][] m ){
        int n = m.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = m[i][j];
                m[i][j]=m[i][n-j-1];
                m[i][n-j-1]=temp;
            }
        }
    }
}