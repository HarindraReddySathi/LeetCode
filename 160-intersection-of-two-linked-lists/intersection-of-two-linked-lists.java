/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        Set<ListNode> sA = new HashSet<>();
        Set<ListNode> sB = new HashSet<>();
        while(headA!=null || headB!=null){
            if(headA!=null){
                sA.add(headA);
                if(sB.contains(headA)) return headA;
                headA=headA.next;
            }
            if(headB!=null){
                sB.add(headB);
                if(sA.contains(headB)) return headB;
                headB=headB.next;
            } 
        }
        return null;
    }
}