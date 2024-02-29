class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        if(nums[0]==0)return false;
        boolean[] dec = new boolean[n];
        dec[0]=true;
        int j=1;
        for(int i=0;i<n;i++){
            if(j<=i) return false;
            if(i+nums[i]>=j){
                 while(j<=i+nums[i]){
                    if(j==n-1) return true;
                    dec[j]=true;
                    j++;
                }
            }
        }
        return false;
    }
}