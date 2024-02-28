class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(robCases(nums,n-1,0),robCases(nums,n,1));
    }

    public int robCases(int[] nums,int n,int p){

        int[] memo = new int[n+1];
        memo[1]= (p==0)?nums[0]:0;
        for(int i = 2;i<=n;i++){
            int k = (i==n+1)? 1:i;
            memo[i]=Math.max(memo[i-1],memo[i-2]+nums[k-1]);
        }
        return memo[n];
    }
}