/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int low, int high) {
        if (low > high) return null;
        
        int maxIndex = findMaxIndex(nums, low, high);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, low, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, high);
        
        return root;
    }

    private int findMaxIndex(int[] nums, int low, int high) {
        int maxIndex = low;
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}