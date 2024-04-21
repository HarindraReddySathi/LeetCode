class Solution {

    public int mod = 1000000000+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        int[] memo = new int[high+1];
        memo[zero]++;
        memo[one]++;
        int ans =0;
        int start = (zero<one)?zero : one;
        for(int i = start;i<=high;i++){
            if(i>=low) ans = (ans+memo[i])%mod;
            if(i+zero<=high)memo[i+zero] = (memo[i+zero]+memo[i])%mod;
            if(i+one<=high)memo[i+one] = (memo[i+one]+memo[i])%mod;
        }
        return (int)ans;
    }
}