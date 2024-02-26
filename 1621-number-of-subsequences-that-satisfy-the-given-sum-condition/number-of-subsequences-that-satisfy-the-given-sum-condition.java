class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int i =0;int j = n-1;
        long ans =0;
        int mod = 1_000_000_007;
        long[] power = new long[nums.length];
        power[0] = 1;
        for (int k = 1; k < nums.length; k++) {
            power[k] = (power[k - 1] << 1) % mod;
        }
        while(j>=i){
            if(nums[i]+nums[j]<=target){
                ans = (ans+power[j - i]) % mod;
                i++;
            }else{
                j--;
            }
        }
        return (int)ans;
    }
}