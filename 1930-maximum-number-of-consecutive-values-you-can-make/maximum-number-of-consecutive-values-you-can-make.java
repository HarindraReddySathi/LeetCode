class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans = 0;
        for(int i : coins){
            if(i<=ans+1){
                ans +=i;
            }else{
                break;
            }
        }
        return ans+1;
    }
}