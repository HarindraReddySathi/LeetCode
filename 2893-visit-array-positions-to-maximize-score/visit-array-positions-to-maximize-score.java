class Solution {
    public long maxScore(int[] nums, int x) {
        
        int n = nums.length;
        if(n==1) return nums[0];
        long[] memo = new long[2];
        memo[nums[0]%2] = nums[0];
        int pop = (nums[0]%2==0)? 1:0;
        memo[pop] = nums[0]-x;
        for(int i =1;i<n;i++){
            int dec = nums[i]%2;
            int diff = (dec==0) ? 1:0;
            long same = 0l+nums[i]+memo[dec];
            long change = 0l+nums[i]+memo[diff]-x;
            long ans = (long)Math.max(same,change);
            if(memo[dec]<same)memo[dec]=ans;
        }
        return (long)Math.max(memo[0],memo[1]);
    }
}