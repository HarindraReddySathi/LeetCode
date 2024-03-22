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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode root = head;

        // Finding Mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        // Reversing all the elements starting from MID
        ListNode cur = slow.next;
        ListNode prev = null;

        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev=cur;
            cur=temp;
        }

        // Checking whether it is a palindrome or not
        while(prev!=null){
            if(root.val!=prev.val) return false;
            root=root.next;
            prev=prev.next;
        }
        return true;   
    }
}