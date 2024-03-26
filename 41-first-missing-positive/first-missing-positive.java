class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int firstPositive = -1;
        for(int i=0;i<n;i++){
            if(nums[i]<=0) continue;
            firstPositive = nums[i];
            break;
        }
        if(firstPositive==-1) return 1;
        for(int i=0;i<n;i++){
            if(nums[i]>0) continue;
            nums[i]=firstPositive;
        }
        for(int i =0;i<n;i++){
            int k = Math.abs(nums[i]);
            if(k-1<n && nums[k-1]>0) nums[k-1]*=-1;
        }
        for(int i =0;i<n;i++){
            if(nums[i]>0) return i+1;
        }
        return n+1;
    }
}