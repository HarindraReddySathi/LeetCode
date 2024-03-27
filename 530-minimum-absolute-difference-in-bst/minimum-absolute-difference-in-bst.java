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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        int res = Integer.MAX_VALUE;
        for(int i=1;i<ans.size();i++){
            if(res>ans.get(i)-ans.get(i-1)) res = ans.get(i)-ans.get(i-1);
        }
        return res;
    }

    public void inOrder(TreeNode root, List<Integer> ans){
        if(root==null) return;
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
}