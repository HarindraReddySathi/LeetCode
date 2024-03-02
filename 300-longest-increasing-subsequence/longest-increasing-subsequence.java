class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        Arrays.fill(max,1);
        int ans = 1;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    max[i]=Math.max(max[i],max[j]+1);
                    if(ans<max[i]) ans = max[i];
                }
            }
        }
        return ans;
    }
}