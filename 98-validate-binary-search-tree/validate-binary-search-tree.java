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
    
    //TC -o(N) SC-O(H)
    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }

        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }

        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    // //TC -o(N) SC-O(N)
    /*public boolean isValidBST(TreeNode root) {
        if(root==null || (root.left==null&&root.right==null)) return true;
        List<Integer> l = new ArrayList<>();
        inOrder(root,l);
        for(int i=1;i<l.size();i++){
            if(l.get(i)<=l.get(i-1)) return false;
        }
        return true;
    }

    public void inOrder(TreeNode root,List<Integer> l){
        if(root==null) return;
        inOrder(root.left,l);
        l.add(root.val);
        inOrder(root.right,l);
    }*/

    /*int checker = Integer.MIN_VALUE;
    boolean dec = true;
    boolean firstCheck = true;
    public boolean isValidBST(TreeNode root) {
        
        inOrder(root);
        return dec;
    }

    public void inOrder(TreeNode root){

        if(!dec)return;
        if(root==null)return;
        inOrder(root.left);
        if(!firstCheck){
            if(root.val<=checker){
            dec = false;
            }
        }else{
            firstCheck=false;
        }
        checker = root.val;
        inOrder(root.right);
    }*/
}