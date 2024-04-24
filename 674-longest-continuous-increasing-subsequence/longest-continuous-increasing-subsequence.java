class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int n = nums.length;
        int max =1;
        int temp =1;
        int i=0,j=1;
        while(i<n && j<n){
            if(nums[j]>nums[i]){
                temp++;
            }else{
                if(temp>max)max = temp;
                temp=1;
            }
            i++;j++;
        }
        if(temp>max)max = temp;
        return max;
    }
}