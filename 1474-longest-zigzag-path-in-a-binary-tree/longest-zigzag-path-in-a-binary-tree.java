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

    int ans =0;

    public int longestZigZag(TreeNode root) {
        
        int left = DFS(root.right,1);
        int right = DFS(root.left,-1);

        if(left>ans) ans =left;
        if(right>ans) ans = right;

        return ans;
    }

    public int DFS(TreeNode root,int parent_direction){

        if(root == null){
            return 0;
        }

        int left = DFS(root.left,-1);
        int right = DFS(root.right,1);
        
        if(left>ans) ans =left;
        if(right>ans) ans = right;

        return (parent_direction==1) ? left+1: right+1;

    }
}