/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        if(slow==null) return false;
        ListNode fast = head.next;
        if(fast ==null) return false;
        while(slow!=null && fast!=null){
            slow=slow.next;
            if(fast.next==null) break;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}