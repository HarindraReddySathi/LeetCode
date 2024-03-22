class Solution {
    public long maximumTripletValue(int[] nums) {
       int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for(int i =1;i<n-1;i++){
            prefix[i] = Math.max(nums[i-1],prefix[i-1]);
            //System.out.println(prefix[i]);
        }
        for(int i =n-2;i>0;i--){
            suffix[i] = Math.max(nums[i+1],suffix[i+1]);
            //System.out.println(suffix[i]);
        }
        long max =0;
        for(int i=1;i<n-1;i++){
            long k = 1l*(prefix[i]-nums[i])*suffix[i];
            max = Math.max(k,max);
        }
        return max; 
    }
}