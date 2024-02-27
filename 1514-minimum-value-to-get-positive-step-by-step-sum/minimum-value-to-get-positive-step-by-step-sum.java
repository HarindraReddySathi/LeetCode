class Solution {
    public int minStartValue(int[] nums) {
        
        int sum =0;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            min=Math.min(sum,min);
        }
        if(min>=0)return 1;
        return 1-min;
    }
}