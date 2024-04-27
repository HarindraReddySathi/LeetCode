class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0]=nums[0];
        int min = Math.min(0,nums[0]);
        int max = Math.max(0,nums[0]);
        int ans = Math.abs(nums[0]);
        for(int i =1;i<n;i++){
            prefix[i] += (prefix[i-1]+nums[i]);
            //System.out.println(prefix[i]+" -- "+i+" -- "+ans+" -- "+min);
            if(prefix[i]<min){
                min = prefix[i];
                //System.out.println("****");
                if(ans < max-min) ans = max -min;
                continue;
            }
            if(prefix[i]>max)max = prefix[i];
            if(ans < prefix[i]-min) ans = prefix[i]-min;
        }
        return ans;
    }
}