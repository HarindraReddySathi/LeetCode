class Solution {
    public int triangularSum(int[] nums) {
        
        int n = nums.length;
        for(int j =0;j<n;j++){
            for(int i=1;i<n-j;i++){
                nums[i-1]=(nums[i-1]+nums[i])%10;
            }
        }
        return nums[0];
    }
}