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
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        
        postOrderTraversal(root,-1);
        return ans;
    }

    public int postOrderTraversal(TreeNode root,int previous){

        if(root == null) return 0;

        int right = postOrderTraversal(root.right,1);
        int left = postOrderTraversal(root.left,0);

        ans = Math.max(Math.max(right,left),ans);

        return (previous==0) ? right+1 : left+1;
    }
}