class Solution {

    /*public int findDuplicate(int[] nums) {
        //TC -(Nlog(N)) SC-(O(1))
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) return nums[i];
        }
        return -1;
    }*/

    public int findDuplicate(int[] nums) {
        // TC  O(N). SC - O(1) but array is modified
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[Math.abs(nums[i])-1]<0){
                return Math.abs(nums[i]);
            }else{
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }
        return 0;
    }
}