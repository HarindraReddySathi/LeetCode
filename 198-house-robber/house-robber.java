class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] memo = new int[n+1];
        memo[1]=nums[0];
        for(int i=2;i<=n;i++){
            memo[i]=Math.max(memo[i-1],memo[i-2]+nums[i-1]);
        }
        return memo[n];
    }
}