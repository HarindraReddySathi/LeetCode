class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        if(n==1){
            if(nums[0]>target)return 1;
            return 0;
        }
        int min =Integer.MAX_VALUE;
        int i=0;int j=0;
        int sum =nums[0];
        while(i<n && j<n){

            if(sum>=target){
                if(j==i) return 1;
                if(min>(j-i+1))min=j-i+1;
                sum=sum-nums[i];
                i++;
            }else{
                j++;
                if(j<n)sum=sum+nums[j];
            }
        }

        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }
}