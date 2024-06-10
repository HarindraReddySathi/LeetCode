class Solution {
    public int[] finalPrices(int[] prices) {
        
        int noOfShops = prices.length;
        Stack<Integer> monotonicStack = new Stack<>();
        for(int i = noOfShops-1; i>=0; i--){

            int currentPrice = prices[i];

            while(!monotonicStack.isEmpty() && prices[i]<monotonicStack.peek()){
                monotonicStack.pop();
            }

            prices[i] = (monotonicStack.isEmpty()) ?  currentPrice : currentPrice-monotonicStack.peek();

            monotonicStack.push(currentPrice);
        }
        return prices;
    }
}