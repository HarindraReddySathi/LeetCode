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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth ==1){
            TreeNode t = new TreeNode(val);
            t.left = root;
            return t;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int stage =1;
        while(!q.isEmpty()){
            int size = q.size();
            if(stage==depth-1){
                for(int i=0;i<size;i++){
                    TreeNode t = q.poll();
                    TreeNode l = new TreeNode(val);
                    l.left = t.left;
                    t.left = l;
                    TreeNode r = new TreeNode(val);
                    r.right = t.right;
                    t.right=r;
                }
                break;
            }else{
                for(int i=0;i<size;i++){
                    TreeNode t = q.poll();
                    if(t.left!=null) q.add(t.left);
                    if(t.right!=null) q.add(t.right);
                }
            }
            stage++;
        }
        return root;
    }
}