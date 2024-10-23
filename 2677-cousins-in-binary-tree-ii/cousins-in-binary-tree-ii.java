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
    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer,Integer> levelSum = LevelSum(root);
        //System.out.println(levelSum.toString());
        root.val=0;
        DFS(levelSum, root,2);
        return root;
    }

    public void DFS(Map<Integer,Integer> levelSum, TreeNode root, int level){

        if(root.left ==null && root.right ==null) return;
        int left = (root.left==null) ? 0 : root.left.val;
        int right = (root.right==null) ? 0 : root.right.val;
        if(root.left!= null) root.left.val = levelSum.get(level)-left-right;
        if(root.right!= null) root.right.val = levelSum.get(level)-left-right;
        if(root.left!= null) DFS(levelSum, root.left,level+1);
        if(root.right!= null) DFS(levelSum, root.right,level+1);
    }


    public Map<Integer,Integer> LevelSum(TreeNode root) {
        Map<Integer,Integer> levelSum = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        levelSum.put(1,root.val);
        q.add(root);
        int level =2;
        while(!q.isEmpty()){

            int size = q.size();
            int sum =0;
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
            //System.out.println(sum);
            if(!q.isEmpty()){
                levelSum.put(level,sum);
            }

            level++;
        }
        return levelSum;
    }
}