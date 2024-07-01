class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;

        // Ensure all elements are positive and within the range [0, k-1]
        for (int i = 0; i < n; i++) {
            nums[i] = ((nums[i] % k) + k) % k;
        }

        int maximumLength = 0;

        // Iterate over all possible remainders
        for (int j = 0; j < k; j++) {
            int[] status = new int[k];
            int length = 0;

            for (int i = 0; i < n; i++) {
                int remainder = nums[i];
                int req = (k + j - remainder) % k;

                status[remainder] = Math.max(status[remainder], status[req] + 1);
                length = Math.max(length, status[remainder]);
            }

            maximumLength = Math.max(maximumLength, length);
        }

        return maximumLength;
    }
}
