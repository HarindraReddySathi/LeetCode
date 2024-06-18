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
    public int deepestLeavesSum(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = root.val;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int curans =0;
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                curans+=cur.val;
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            ans = curans;
        }
        return ans;
    }
}