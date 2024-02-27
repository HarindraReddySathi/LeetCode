class Solution {
    public int pivotIndex(int[] nums) {
        long totalSum = 0l;
        int n = nums.length;
        if(n==1) return 0;
        //int[] prefixSum = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=(int)(totalSum+nums[i]);
            totalSum=nums[i];
        }
        for(int i=0;i<n;i++){
            if(i==0){
                if((totalSum-nums[i])==0) return 0;
            }else if(i==n-1){
                if(nums[i-1]==0) return n-1;
            }else{
               if(nums[i-1]==(totalSum-nums[i])) return i;
            }
        }
        return -1;
    }
}