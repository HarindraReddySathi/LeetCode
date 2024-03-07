class Solution {
    public int findMin(int[] nums) {
        int l=0, r = nums.length -1 ; // l - left,  r - right
        int m; //mid
        while(l < r){
            m = l+(r-l)/2; //default mid
            if(nums[m] > nums[r]){ 
                l = m+1;
            }else{ 
                r = m;
            }
        }
        return nums[r];
    }
}