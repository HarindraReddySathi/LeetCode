class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int[] memo = new int[n];
        int start=1;
        int step =1;
        for(int i=0;i<n;i++){
            step=memo[i]+1;
            int end = (i+nums[i]>n-1)?n-1:i+nums[i];
            while(end>=start){
                memo[start++]=step;
            }
        }
        return memo[n-1];
    }
}