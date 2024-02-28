class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] up = new boolean[2*n+1];
        boolean[] down = new boolean[2*n+1];
        boolean[] x = new boolean[n];
        boolean[] y = new boolean[n];

        List<List<String>> ans = new ArrayList<>();
        int[][] temp = new int[n][n];

        queens(ans,up,down,x,y,temp,0,n);
        return ans;
    }

    public void queens(List<List<String>> ans, boolean[] up, boolean[] down, boolean[] x, boolean[] y,
            int[][] temp, int level,int n) {
                if(level==n){
                    convertToString(ans,temp,n);
                    return;
                }
                for(int j=0;j<n;j++){
                    if(!up[level+j] && !down[n-level+j] && !x[level] && !y[j] ){
                        temp[level][j]=1;
                        up[level+j]=true;down[n-level+j]=true;x[level]=true;y[j]=true;
                        queens(ans,up,down,x,y,temp,level+1,n);
                        up[level+j]=false;down[n-level+j]=false;x[level]=false;y[j]=false;
                        temp[level][j]=0;
                    }
                }
    }
    public void convertToString(List<List<String>> ans,int[][] memo,int n){

        List<String> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(memo[i][j]==0)sb.append(".");
                else sb.append("Q");
            }
            temp.add(sb.toString());
        }
        ans.add(temp);
    }
}