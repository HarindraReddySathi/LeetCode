class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;
        int n = nums.length;
        //System.out.println(n);
        if(2*k>=n){
            nums = new int[n];
            Arrays.fill(nums,-1);
            return nums;
        }
        int[] ans = new int[n];
        long[] temp = new long[n];
        int start =k;
        int end = n-k;
        long sum=0;
        for(int i=0;i<2*k;i++){
            sum+=nums[i];
        }
        //System.out.println(sum);
        for(int i = start;i<end;i++){
            sum+=nums[i+k];
            temp[i]=sum;
            sum-=nums[i-k];
        }
        int div = (2*k+1);
        for(int i=0;i<n;i++){
            if(i<k || i>=end) ans[i]=-1;
            else{
                ans[i] = (int)(temp[i]/div);
            }
        }
        return ans;
    }
}