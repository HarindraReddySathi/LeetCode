class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        
        for (int bit = 0; bit < 30; bit++) {
            Integer lastOne = null;
            for (int idx = n - 1; idx >= 0; idx--) {
                if (((nums[idx] >> bit) & 1) == 1) {
                    res[idx] = Math.max(res[idx], 1);
                    lastOne = idx;
                } else {
                    if (lastOne != null) {
                        res[idx] = Math.max(res[idx], lastOne - idx + 1);
                    }
                }
            }
        }
        return res;

    }
}