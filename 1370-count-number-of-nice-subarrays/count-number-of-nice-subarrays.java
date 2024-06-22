class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return subArraysAtMostK(nums, k) - subArraysAtMostK(nums, k - 1);
    }

    public int subArraysAtMostK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int ans = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                count++;
            }

            while (count > k) {
                if (nums[j++] % 2 != 0) {
                    count--;
                }
            }

            ans += i - j + 1;
        }

        return ans;
    }
}
