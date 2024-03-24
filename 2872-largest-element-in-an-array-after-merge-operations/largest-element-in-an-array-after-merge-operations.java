class Solution {
    public long maxArrayValue(int[] nums) {
        long ans =0l;
        int n = nums.length;
        long temp=0l;
        for(int i=n-1;i>=0;i--){
            if(temp<nums[i]){
                ans=(long)Math.max(temp,ans);
                temp=nums[i];
            }else{
                temp+=nums[i];
            }
        }
        ans=(long)Math.max(temp,ans);
        return ans;
    }
}