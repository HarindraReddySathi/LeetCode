class Solution {
    public int mostFrequent(int[] nums, int key) {

       int[] ans = new int[1001];
       int max = Integer.MIN_VALUE;
       int res =-1;
       for(int i=1;i<nums.length;i++){
        if(nums[i-1]==key){
            ans[nums[i]]++;
            if(ans[nums[i]]>max){
                max = ans[nums[i]];
                res = nums[i];
            }
        }
       }
       return res;
    }
}