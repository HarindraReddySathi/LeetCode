class Solution {
    public int minimumDeletions(int[] nums) {
        
        int n = nums.length;
        if(n<=2) return n;
        if(n==3) return 2;
        int min = Integer.MAX_VALUE;
        int minPos = -1;
        int max = Integer.MIN_VALUE;
        int maxPos =-1;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
                maxPos=i;
            }
            if(nums[i]<min){
                min=nums[i];
                minPos=i;
            }
        }
        int ans =0;
        ans = Math.max(maxPos,minPos)+1;
        ans=Math.min(ans,(n-Math.min(maxPos,minPos)));
        ans=Math.min(ans,Math.min(maxPos,minPos)+1+n-Math.max(maxPos,minPos));
        return ans;
    }
}