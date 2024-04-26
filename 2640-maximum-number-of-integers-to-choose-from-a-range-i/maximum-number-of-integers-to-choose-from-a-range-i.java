class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        boolean[] set = new boolean[n+1];
        for(int i : banned){
            if(i<=n)set[i]=true;
        }
        int ans =0;
        for(int i =1;i<=n;i++){
            if(i<=maxSum){
                if(set[i]) continue;
                ans++;
                maxSum-=i;
            }else{
                break;
            }
        }
        return ans;
    }
}