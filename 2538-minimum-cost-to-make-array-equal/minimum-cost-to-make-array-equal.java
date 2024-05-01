class Solution {
    public long minCost(int[] num, int[] cost) {
        
        int n = num.length;
        int[][] nums = new int[n][2];
        for(int i=0;i<n;i++){
            nums[i][0] = num[i];
            nums[i][1] = cost[i];
        }
        Arrays.sort(nums,(a,b) -> a[0]-b[0]);
        long[] suffix = new long[n];
        long[] prefix = new long[n];
        long prev = nums[n-1][1];
        for(int i = n-2;i>=0;i--){
            suffix[i] = suffix[i+1] + (prev)*(nums[i+1][0]-nums[i][0]);
            prev += nums[i][1];
        }
        prev = nums[0][1];
        for(int i =1;i<n;i++){
            prefix[i] = prefix[i-1] + (prev)*(nums[i][0]-nums[i-1][0]);
            prev += nums[i][1];
        }
        long ans = Long.MAX_VALUE;
        for(int i =0 ;i<n;i++){
            if(prefix[i]+suffix[i]<ans) ans = prefix[i]+suffix[i];
        }
        return ans;
    }
}