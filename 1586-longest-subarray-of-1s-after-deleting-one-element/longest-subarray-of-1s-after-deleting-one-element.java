class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i=0;
        int j=0;
        int prev = 0;
        int ans = 0;
        int z = 0;
        while(j<n) {
            while(j<n && nums[j] == 0) {
                z++;
                j++;
            }
            i=j;
            if(z>1) prev = 0;
            z=0;
            while(j<n && nums[j] == 1) {
                j++;
            }
            int cur = j-i;
            if(ans<cur+prev) ans = cur+prev;
            if(j==n) break;
            prev = cur;
            i=j;
            
        }

        return ans==n?n-1:ans;
    }
}