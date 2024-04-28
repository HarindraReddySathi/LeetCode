class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        int n = nums.length;
        if(n==1) return nums[0];
        long ans =0;
        int prev =0;
        for(int i=0;i<n;i++){
            if(prev ==0 || nums[i]>prev){
                prev = nums[i];
                continue;
            }
            if(i!=n-1){
                if(nums[i]<nums[i+1]){
                    ans+=(prev-nums[i]);
                    prev=0;
                }
            }
        }
        return ans+prev;

    }
}