class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int ans =nums[0],temp=nums[0];
        int j=1;
        while(j<n){
            while(j<n && nums[j]>nums[j-1]){
                temp+=nums[j];
                j++;
            }
            ans=Math.max(ans,temp);
            if(j<n)temp=nums[j++];
        }
        return ans;
    }
}