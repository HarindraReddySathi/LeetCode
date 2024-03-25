class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        int div = (2*k+1);
        if(2*k>=n) return ans;
        long sum=0;
        for(int i=0;i<2*k;i++){
            sum+=nums[i];
        }
        for(int i = k;i<n-k;i++){
            sum+=nums[i+k];
            ans[i]=(int)(sum/div);
            sum-=nums[i-k];
        }
        return ans;
    }
}