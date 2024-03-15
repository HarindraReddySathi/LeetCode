class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        //Arrays.fill(ans,1);
        int prev=1;
        int suf=1;
        for(int i =0;i<n;i++){
            ans[i]=prev;
            prev*=nums[i];
        }
        for(int i =n-1;i>=0;i--){
            ans[i]*=suf;
            suf*=nums[i];
        }
        return ans;
    }
}