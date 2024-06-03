class Solution {
    public long sumDigitDifferences(int[] nums) {
        
        long ans =0;
        while(nums[0]>0){
            int[] demo = new int[10];
            for(int i=0;i< nums.length ; i++){
                demo[nums[i]%10]++;
                nums[i]/=10;
            }
            for(int i=0;i<10;i++){
                for(int j=0;j<i;j++){
                    ans+=(1l*demo[i]*demo[j]);
                }
            }
        }
        return ans;
    }
}