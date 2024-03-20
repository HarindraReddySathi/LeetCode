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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode root = list1;
        //root.next = list1;
        int pos=0;
        while(pos!=a-1){
            list1=list1.next;
            pos++;
        }
        ListNode start = list1;
        while(pos!=b){
            list1=list1.next;
            pos++;
        }
        ListNode end = list1.next;
        list1.next=null;
        start.next=list2;
        while(start.next!=null){
            start=start.next;
        }
        start.next=end;
        return root;
    }
}