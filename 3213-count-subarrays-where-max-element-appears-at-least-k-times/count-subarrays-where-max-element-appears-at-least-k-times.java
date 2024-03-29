class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int max = nums[0];
        for(int i : nums) if(max<i) max=i;
        int j=0;
        long ans =0;
        int count=0;
        for(int i=0;i<n;i++){
            while(j<n && count<k){
                if(nums[j++]==max) count++;
            }
            if(j==n && count<k) break;
            ans += n-j+1;
            if(nums[i]==max)count--;
        }
        return ans;
    }
}