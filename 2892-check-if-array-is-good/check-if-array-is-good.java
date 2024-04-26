class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int l =0;
        for(int i=0;i<n;i++){
            int cur = Math.abs(nums[i])-1;
            if(cur>=n-1) return false;
            if(cur == n-2){
                l++;
                if(l>2) return false;
            }else{
                if(nums[cur]<0) return false;
                nums[cur]*=-1;
            }
        }
        return true;
    }
}