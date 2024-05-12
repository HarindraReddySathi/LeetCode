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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> validPaths = new ArrayList<>();
        if(root==null) return validPaths;
        List<Integer> path = new ArrayList<>();
        DFS(root,targetSum,path,validPaths);
        return validPaths;
    }

    public void DFS(TreeNode root, int targetSum,List<Integer> path,List<List<Integer>> validPaths){

        if(root.left==null && root.right==null){
            if(targetSum - root.val==0){
                List<Integer> validPath = new ArrayList<>();
                validPath.addAll(path);
                validPath.add(root.val);
                validPaths.add(validPath);
            }
            return;
        }
        path.add(root.val);
        if(root.left!=null)DFS(root.left,targetSum-root.val,path,validPaths);
        if(root.right!=null)DFS(root.right,targetSum-root.val,path,validPaths);
        path.remove(path.size()-1);

    }
}