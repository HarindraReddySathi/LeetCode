class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return subArraysGreaterThanK(nums,k) - subArraysGreaterThanK(nums,k+1);
    }

    public int subArraysGreaterThanK(int[] nums , int k){

        int n = nums.length;
        int count =0;
        int ans =0;
        for(int i=0,j=0 ;i<n;i++){
            if(i!=0){
                if((nums[i-1]&1)!=0) count--;
            }
            while(j<n && count<k){
                if((nums[j++]&1)!=0) count++;
            }
            if(count>=k)ans += n-j+1; 
        }
        return ans;
    }
}