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
    public TreeNode sortedListToBST(ListNode head) {
        /*
            1. create a left child
            2. if still you have elements create root
            3. if still you have elemets create right child
        */
        ListNode start = head;
        int size =0;
        while(start !=null){
            start=start.next;
            size++;
        }
        int[] list = new int[size];
        start = head;
        int pos=0;
        while(start !=null){
            list[pos++] = start.val;
            start=start.next;
        }

        return DivideandConquer(list,0,size-1);
    }

    public TreeNode DivideandConquer(int[] list,int start,int end){
        
        if(start>end) return null;

        int mid = start + ((end-start)>>1);
        TreeNode root = new TreeNode(list[mid]);
        root.left = DivideandConquer(list,start,mid-1);
        root.right = DivideandConquer(list,mid+1,end);
        return root;


    }
}