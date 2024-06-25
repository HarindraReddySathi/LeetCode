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
    public TreeNode bstToGst(TreeNode root) {
        greaterSumTreeBuilder(root,0);
        return root;
    }

    public int greaterSumTreeBuilder(TreeNode root,int prevSum){

        if(root == null) return prevSum;

        int sum = greaterSumTreeBuilder(root.right,prevSum);
        root.val+=sum;
        return greaterSumTreeBuilder(root.left,root.val);

    }
}