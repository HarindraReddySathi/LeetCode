class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;

        // Initialize max and min products for the first element
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                // Swap max and min when encountering a negative number
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Update maxProduct and minProduct
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            // Update the result to hold the maximum product found so far
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}