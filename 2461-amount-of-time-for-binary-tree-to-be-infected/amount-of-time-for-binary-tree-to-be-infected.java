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

    //public Map<Integer,Integer> map = new HashMap<>();
    //if(!isRootFound)Map.put(root.val,Math.max(left,right));
    public int amountOfTime(TreeNode root, int start) {
        int[] startDist = new int[1];
        int[] ans = new int[1];
        boolean[] isRootFound = new boolean[1];
        DFS(root,start,isRootFound,startDist,ans);
        return ans[0];
    }

    public int DFS(TreeNode root, int start,boolean[] isRootFound,int[] startDist,int[] ans){

        if(root==null) return 0;

        boolean startFound = false;
        int left = DFS(root.left,start,isRootFound,startDist,ans);
        if(isRootFound[0]){
            startFound=true;
            isRootFound[0] = false;
        }
        int right = DFS(root.right,start,isRootFound,startDist,ans);
        if(startFound){
            isRootFound[0]=true;
            ans[0] = Math.max(right+startDist[0],ans[0]);
        }else{
            ans[0] = Math.max(left+startDist[0],ans[0]);
        }
        if(root.val==start){
            isRootFound[0] = true;
            ans[0] = Math.max(Math.max(left,right),ans[0]);
        } 
        if(isRootFound[0])startDist[0]++;
        return 1+Math.max(left,right);
    }


}