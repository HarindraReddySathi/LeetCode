class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if(k==0 || k==1) return 0;

        int n = nums.length;
        int j = 0;
        int curProduct =1;
        int ans =0;

        for(int i=0;i<n;i++){

            if(j<i) j=i;

            while(j<n && curProduct*nums[j]<k){
                curProduct*=nums[j];
                j++;

            }

            ans += j-i;

            if(j>i)curProduct /= nums[i];
        }

        return ans;
    }
}