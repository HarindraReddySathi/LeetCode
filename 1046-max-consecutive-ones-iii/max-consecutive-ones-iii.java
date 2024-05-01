class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;
        int count =0;
        int ans =0,j=0;
        for(int i=0;i<n;i++){

            while(j<n && count<=k){
                if(nums[j]==0 && count==k) break;
                if(nums[j]==0 && count<k) count++;
                j++;
            }
            if(j-i>ans) ans = j-i;
            if(j==n) break;
            if(nums[i]==0) count--;
        }
        return ans;
    }
}