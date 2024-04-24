class Solution {
    int s;
    void ans(int nums[], int i, int sum){
        if(i==nums.length-1){
            s+=(sum^nums[i])+sum;
            return;
        }
        ans(nums, i+1, sum);
        ans(nums, i+1, sum^nums[i]);
    }
    public int subsetXORSum(int[] nums) {
        s=0;
        ans(nums, 0, 0);
        return s;
    }
}