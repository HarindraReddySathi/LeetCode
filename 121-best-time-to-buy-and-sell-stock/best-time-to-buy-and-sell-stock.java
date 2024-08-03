class Solution {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices) {
            minVal = Math.min(minVal, price);
            profit = Math.max(profit, price - minVal);
        }
        return profit;
    }
}