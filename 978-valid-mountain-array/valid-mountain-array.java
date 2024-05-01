class Solution {
    public boolean validMountainArray(int[] nums) {
        
        int n = nums.length;
        if(n<3) return false;
        if(nums[0]>=nums[1]) return false;
        boolean isIncreasing = true;
        for(int i =1;i<n;i++){

            if(nums[i]>nums[i-1] && isIncreasing) continue;
            if((nums[i]>nums[i-1] && !isIncreasing) || (nums[i]==nums[i-1])) return false;
            if(nums[i]<nums[i-1] && isIncreasing){
                isIncreasing=false;
            }

        }

        return !isIncreasing;
    }
}