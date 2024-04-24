class Solution {
    public int subsetXORSum(int[] nums) {
        
        int bits =0;
        for(int i : nums){
            bits |=i;
        }
        int n = nums.length-1;
        return bits*(1<<n);
    }
}