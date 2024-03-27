class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0 || k==1) return 0;
        long product =1;
        int ans =0;
        int i=0;
        int j=0;
        int n = nums.length;
        while(i<n){
            while(j<n && product<k){
               product*=nums[j];
               j++; 
            }
            if(product>=k)ans+=(j-i-1);
            else ans+=(j-i);
            product/=nums[i];
            i++;
        }
        return ans;
    }
}