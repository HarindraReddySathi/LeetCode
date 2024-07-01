class Solution {
    public double minimumAverage(int[] nums) {
        
        int n = nums.length;
        int i =0 , j=n-1;
        
        Arrays.sort(nums);
        
        int ans = 101;

        while(i<j){
            int temp = (nums[i]+nums[j]);
            if(temp<ans){
                ans = temp;
            }
            i++;
            j--;
        }

        return (0d+ans)/2;
    }
}