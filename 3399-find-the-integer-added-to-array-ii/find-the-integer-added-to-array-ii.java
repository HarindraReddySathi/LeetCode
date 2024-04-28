
public class Solution {

    // Helper method to check if nums2 can be obtained by potentially skipping up to two elements from nums1
    private boolean isPossible(int[] nums1, int[] nums2) {
        int i = 0, j = 0, stepsLeft = 2;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                i++;
                j++;
            } else {
                i++;
                stepsLeft--;
                if (stepsLeft < 0) {
                    return false;
                }
            }
        }
        return j == nums2.length && (i - j) <= 2;
    }

    // Main method to find the minimum integer that can be added to nums1 to make it match nums2 as closely as possible
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Map<Integer, Integer> mapp = new HashMap<>();
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int diff = nums2[j] - nums1[i];
                mapp.put(diff, mapp.getOrDefault(diff, 0) + 1);
            }
        }

        for (int k : mapp.keySet()) {
            int[] curr = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                curr[i] = nums1[i] + k;
            }
            Arrays.sort(curr);

            if (this.isPossible(curr, nums2)) {
                mini = Math.min(mini, k);
            }
        }

        return mini;
    }
}
