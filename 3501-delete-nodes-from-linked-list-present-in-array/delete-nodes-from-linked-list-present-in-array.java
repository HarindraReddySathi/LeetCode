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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> omitNumbers = new HashSet<>();
        for(int i : nums) omitNumbers.add(i);

        ListNode cur = new ListNode(-1);
        cur.next = head;
        head = cur;
        cur = head.next;
        ListNode pre = head;
        while(cur!=null){
            
            if(omitNumbers.contains(cur.val)){
                pre.next = cur.next;
            }else{
                pre = pre.next;
            }
            cur = cur.next;

        }
        return head.next;
    }
}