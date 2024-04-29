class Solution {
    public int maximizeSum(int[] nums, int k) {
        
        int max = 0;
        for(int i : nums) if(max<i) max=i;
        return k*(2*max+k-1)>>1;
    }
}