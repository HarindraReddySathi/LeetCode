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
    public int pairSum(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        temp =head;
        int end = length/2;
        ListNode prev = null;
        for(int i =0;i<end;i++){
            ListNode t = temp.next;
            temp.next = prev;
            prev= temp;
            temp=t;
        }
        int ans =0;
        while(temp!=null){
            int cur = temp.val+prev.val;
            if(cur>ans)ans=cur;
            temp = temp.next;
            prev=prev.next;
        }
        return ans;
    }
}