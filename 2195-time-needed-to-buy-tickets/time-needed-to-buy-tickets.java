class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        if(tickets[k]==1) return k+1;
        int n = tickets.length;
        int val = tickets[k];
        int ans =0;
        for(int i=0;i<n;i++){
            if(i<=k){
                ans+=Math.min(val,tickets[i]);
            }else{
                ans+=Math.min(val-1,tickets[i]);
            }
        }
        return ans;
    }
}