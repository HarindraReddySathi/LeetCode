class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int[] isVisited = new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(isVisited[i]==0){
                ans++;
                DFS(isConnected,isVisited,i,n);
            }
        }
        return ans;
    }

    public void DFS(int[][] isConnected,int[] isVisited,int i,int n){

        if(isVisited[i]==1) return ;
        isVisited[i]=1;
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1){
                DFS(isConnected,isVisited,j,n);
            }
        }
    }
}