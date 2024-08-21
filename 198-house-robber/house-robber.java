class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;

        if(n==1) return nums[0];

        int pre = nums[1]>=nums[0] ? nums[1] : nums[0];
        int prePre = nums[0];

        for(int i=2;i<n;i++){
            int temp = pre;

            pre = Math.max(pre,prePre+nums[i]);
            prePre = temp;
        }

        return (pre>=prePre) ? pre : prePre;

    }
}