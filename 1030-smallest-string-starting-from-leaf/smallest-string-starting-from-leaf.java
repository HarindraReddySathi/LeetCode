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
    public String smallestFromLeaf(TreeNode root) {
        if(root == null ) return "";
        String[] str = new String[1];
        StringBuilder sb = new StringBuilder();
        DFS(root,str,sb);
        return str[0];
    }

    public void DFS(TreeNode root,String[] str,StringBuilder sb){

        sb.append((char)(root.val+'a')+"");
        //System.out.println(sb.toString());
        if(root.left==null && root.right==null){
            //System.out.println("*");
            String cur = sb.reverse().toString();
            sb.reverse();
            if (str[0] == null || cur.compareTo(str[0]) <0) {
                str[0] = cur;
            }
            sb.deleteCharAt(sb.length()-1);
            return ;
        }
        if(root.left!=null){
            DFS(root.left,str,sb);
        }
        if(root.right!=null){
            DFS(root.right,str,sb);
        }
        sb.deleteCharAt(sb.length()-1);
    }
}