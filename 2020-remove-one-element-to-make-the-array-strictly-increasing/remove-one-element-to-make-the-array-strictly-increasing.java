class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        int prev = Integer.MIN_VALUE;
        int dips = 0;

        for(int i=0;i<n;i++) {
            if(nums[i] > prev) {
                prev = nums[i];
            }
            else {
                dips++;
                if(i>1 && nums[i] <= nums[i-2]) prev = nums[i-1];
                else prev = nums[i];
            }
        }
        return dips == 0 || dips == 1;
    }
}