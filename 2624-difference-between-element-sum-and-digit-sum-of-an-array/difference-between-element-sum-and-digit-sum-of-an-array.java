class Solution {
    public int differenceOfSum(int[] nums) {
        
        int n = nums.length;
        int ele = 0;
        int dig =0;
        for(int i=0;i<n;i++){
            ele+=nums[i];
            dig+=digitSum(nums[i]);
        }
        return Math.abs(ele-dig);
    }
    public int digitSum(int n){
        int ans =0;
        while(n>0){
            ans+=n%10;
            n=n/10;
        }
        return ans;
    }
}