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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = findSize(head);
        int min = size/k;
        int rem = size%k;

        ListNode[] splits = new ListNode[k];
        for(int i=0;i<k;i++){
            int curSize = min;
            if(rem>0) curSize +=1;
            if(curSize>0){
                splits[i] = head;
                head = findNextHead(head,curSize);
                rem--;
            }else{
                break;
            }
        }
        return splits;
    }

    public ListNode findNextHead(ListNode head, int size){

        int i=0;
        ListNode pre = null;
        while(i<size){
            pre = head;
            head = head.next;
            i++;
            
        }
        if(pre!=null) pre.next =null;
        return head;
    }

    public int findSize(ListNode head){

        int count =0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
}