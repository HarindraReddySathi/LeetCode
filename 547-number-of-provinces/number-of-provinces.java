class Solution {
    public int findCircleNum(int[][] c) {
        int n = c.length;
        int ans =0;
        int[] memo = new int[n];
        for(int i=0;i<n;i++){
            c[i][i]=0;
        }
        for(int i=0;i<n;i++){
            if(memo[i]==0){
                ans++;
                DFS(c,i,n,memo);
            }
        }
        return ans;
    }

    public void DFS(int[][] c,int i,int n,int[] memo){
       if(memo[i]!=0) return;
       memo[i]=1;
       for(int j=0;j<n;j++){
           if(c[i][j]==1) DFS(c,j,n,memo);
       }
    }
}