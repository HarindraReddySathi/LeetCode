class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] trusted = new int[n+1];
        boolean[] judge = new boolean[n+1];
        int k =trust.length;
        for(int i=0;i<k;i++){
            judge[trust[i][0]]=true;
            trusted[trust[i][1]]++;
        }
        int ans =-1;
        for(int i=1;i<=n;i++){
            if(!judge[i] &&trusted[i]==n-1){
                if(ans==-1) ans =i;
                else return -1;
            }
        }
        return ans;
    }
}