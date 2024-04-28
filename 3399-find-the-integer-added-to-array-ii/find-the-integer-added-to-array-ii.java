
public class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int m = nums2.length;
        int min_x = Integer.MAX_VALUE;  // Initialize min_x to the maximum possible value

        // Generate all combinations of indices to be removed from nums1
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Creating new array of size n-2
                int[] new_nums1 = new int[n - 2];
                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        new_nums1[idx++] = nums1[k];
                    }
                }

                // Calculate x based on the first elements (smallest since both are sorted)
                int x = nums2[0] - new_nums1[0];

                // Check if this x works for all remaining elements in new_nums1
                boolean valid = true;
                for (int k = 0; k < m; k++) {
                    if (nums2[k] != new_nums1[k] + x) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    min_x = Math.min(min_x, x);
                }
            }
        }

        return min_x;
    }
}
