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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int start = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int prev =-1;

        int prevVal = head.val;
        head = head.next;
        int cur = 1;
        while(head!=null){
            if(head.next!=null && (head.val > prevVal && head.val> head.next.val)){
                if(start ==-1){
                    start = cur;
                }else{
                    max = cur-start;
                    if(prev==-1) prev = start;
                    if(min>cur-prev) min = cur-prev;
                    prev = cur;
                }
            }else if(head.next!=null && (head.val < prevVal && head.val < head.next.val)){
                if(start ==-1){
                    start = cur;
                }else{
                    max = cur-start;
                    if(prev==-1) prev = start;
                    if(min>cur-prev) min = cur-prev;
                    prev = cur;
                }
            }
            prevVal = head.val;
            head = head.next;
            cur++;
        }
        if(start ==-1 || prev ==-1) return new int[]{-1,-1};
        return new int[]{min,max};
    }
}