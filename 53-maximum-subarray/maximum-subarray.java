class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) ans=Math.max(ans,nums[i]);
        if(ans<=0) return ans;
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum+nums[i]>=0){
                sum+=nums[i];
                ans=Math.max(ans,sum);
            }else{
                sum=0;
            }
        }
        return ans;
    }
}