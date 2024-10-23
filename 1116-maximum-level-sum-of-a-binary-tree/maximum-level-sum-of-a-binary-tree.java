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
    public int maxLevelSum(TreeNode root) {
        
        int ans =1;
        int max = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level =1;
        int sum = root.val;
        while(!q.isEmpty()){

            int size = q.size();
            sum =0;
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                if(cur.left!=null){
                    q.add(cur.left);
                    sum += cur.left.val;
                } 
                if(cur.right!=null){
                    q.add(cur.right);
                    sum += cur.right.val;
                } 
            }
            System.out.println(sum);
            if(sum>max && !q.isEmpty()){
                max = sum;
                ans = level+1;
            }

            level++;
        }
        return ans;
    }
}