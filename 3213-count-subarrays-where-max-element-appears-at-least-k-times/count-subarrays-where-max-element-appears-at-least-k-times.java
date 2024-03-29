class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int max = nums[0];
        for(int i : nums) if(max<i) max=i;
        int j=0;
        int i=0;
        long ans =0;
        int count=0;
        while(i<n){
            while(j<n && count<k){
                if(nums[j++]==max) count++;
            }
            if(j==n && count<k) break;
            while(i<j && count>=k){
                ans += n-j+1;
                if(nums[i++]==max)count--;
            }
        }
        return ans;
    }
}