/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    
    Map<ListNode,Map<TreeNode,Boolean>> dp = new HashMap<>();
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        return isDownwardPathExists(head,head,root);
    }

    public boolean isDownwardPathExists(ListNode head, ListNode current,TreeNode root){

        if(current == null){
            return true;
        }
        if(root == null){
            return false;
        }

        if(dp.containsKey(current) && dp.get(current).containsKey(root)){
            return dp.get(current).get(root);
        }

        boolean ans = false;

        if(current.val == root.val){
            ans = isDownwardPathExists(head,current.next,root.left) || isDownwardPathExists(head,current.next,root.right);
        }
        
        if(!ans && head.val == root.val){
            ans = isDownwardPathExists(head,head.next,root.left) || isDownwardPathExists(head,head.next,root.right);
        }
        
        if(!ans){
            ans = isDownwardPathExists(head,head,root.left) || isDownwardPathExists(head,head,root.right);
        }
         dp.computeIfAbsent(current, k -> new HashMap<>()).put(root, ans);
        return ans;
    }
}