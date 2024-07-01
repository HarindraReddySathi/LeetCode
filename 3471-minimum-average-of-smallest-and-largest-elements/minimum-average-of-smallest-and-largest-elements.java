class Solution {
    public double minimumAverage(int[] nums) {
        
        int n = nums.length;
        int i =0 , j=n-1;
        
        Arrays.sort(nums);
        
        double ans = 51;

        while(i<j){
            double temp = (0d+nums[i]+nums[j])/2;
            if(temp<ans){
                ans = temp;
            }
            i++;
            j--;
        }

        return ans;
    }
}