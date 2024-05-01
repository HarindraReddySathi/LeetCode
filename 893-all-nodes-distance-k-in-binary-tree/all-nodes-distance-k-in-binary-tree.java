/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public  boolean isTargetFound = false;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        BFS(target,ans,k);
        DFS(root,target.val,k,ans);
        return ans;
    }

    public int DFS(TreeNode root,int target, int k,List<Integer> ans){

        if(root == null) return 0;
        if(target == root.val){
            isTargetFound = true;
            return 1;
        }
        int left = DFS(root.left,target,k,ans);
        if(isTargetFound){
            if(left==k) ans.add(root.val);
            if(root.right!=null && left!=k)BFS(root.right,ans,k-left-1);
            return left+1;
        }
        int right = DFS(root.right,target,k,ans);
         if(isTargetFound){
            if(right==k) ans.add(root.val);
            if(root.left!=null && right!=k)BFS(root.left,ans,k-right-1);
            return right+1;
        }
        return 0;
    }

    public void BFS(TreeNode root,List<Integer> ans,int k){

        Queue<TreeNode> q = new LinkedList<>();
        int level =0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode cur = q.poll();
                if(level ==k) ans.add(cur.val);
                if(cur.left!=null)q.add(cur.left);
                if(cur.right!=null)q.add(cur.right);
            }
            level++;
            if(level>k) return;
        }
        return;
    }
}