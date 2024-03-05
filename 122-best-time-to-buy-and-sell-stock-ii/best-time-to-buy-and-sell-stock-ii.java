class Solution {
    public int maxProfit(int[] prices) {
        
        int n =prices.length;
        int ans = 0;
        int temp=0;
        int i=0;
        int j=1;
        while(i<n && j<n){
            while(j<n && prices[j]>prices[j-1]){
                j++;
            }
            ans+=prices[j-1]-prices[i];
            i=j;
            j++;
        }
        return ans;
    }
}