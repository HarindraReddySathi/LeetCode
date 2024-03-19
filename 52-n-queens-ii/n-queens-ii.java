class Solution {
    public int totalNQueens(int n) {
        boolean[] up = new boolean[2*n+1];
        boolean[] down = new boolean[2*n+1];
        boolean[] y = new boolean[n];
        int[][] temp = new int[n][n];

        return queens(up,down,y,temp,0,n);
    }
    public int queens(boolean[] up, boolean[] down,boolean[] y,
        int[][] temp, int level,int n) {
        if(level==n)return 1;
        int res =0;
        for(int j=0;j<n;j++){
            if(!up[level+j] && !down[n-level+j] && !y[j] ){
                temp[level][j]=1;
                up[level+j]=true;down[n-level+j]=true;y[j]=true;
                res+=queens(up,down,y,temp,level+1,n);
                up[level+j]=false;down[n-level+j]=false;y[j]=false;
                temp[level][j]=0;
            }
        }
        return res;
    }
}