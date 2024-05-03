class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans=0,prev =0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                if(prev>ans) ans=prev;
                prev=0;
            }else{
                prev++;
            }
        }
        return ans<prev ? prev : ans ;
    }
}