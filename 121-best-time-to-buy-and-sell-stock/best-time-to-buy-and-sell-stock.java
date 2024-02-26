class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1) return 0;
        int high =0;
        int ans =0;
        for(int i=n-1;i>=0;i--){
            if(high<prices[i])high=prices[i];
            if(ans<(high-prices[i])) ans=high-prices[i];
        }
        return ans;
    }
}