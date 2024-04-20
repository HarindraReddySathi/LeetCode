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
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        int[] ans = new int[1];
        int[] temp = new int[1];
        dfs(root,sb,ans,temp);
        return ans[0];
    }

    public void dfs(TreeNode root,StringBuilder sb,int[] ans,int[] temp){

        temp[0]*=10;
        temp[0]+=root.val;
        if(root.right==null && root.left==null){
            ans[0] += temp[0];
            temp[0]/=10;
            return;
        }
        if(root.right!=null){
            dfs(root.right,sb,ans,temp);
        }
        if(root.left!=null){
            dfs(root.left,sb,ans,temp);
        }
        temp[0]/=10;
    }
}