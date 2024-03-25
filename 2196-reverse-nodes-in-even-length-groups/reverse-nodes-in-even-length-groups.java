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
 //+9
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode root = head;

        ListNode pre = head;
        ListNode post =null;
        head=head.next;
        int cur=2;
        while(head!=null){
            int len=0;
            ListNode start = head;
            ListNode end = pre;
            while(head!=null && len<cur){
                len++;
                end=head;
                head=head.next;
            }
            if(len%2==0){
                //if(head!=null)System.out.println(pre.val+"--"+start.val+"--"+end.val+"--"+head.val);
                //else System.out.println(pre.val+"--"+start.val+"--"+end.val+"-- null");
                post =head;
                rotate(start,end,pre,post);
                ListNode temp = start;
                start=end;
                end=temp;
            }
            pre=end;
            cur++;
        }
        return root;
    }

    public void rotate(ListNode start,ListNode end,ListNode pre,ListNode post){

        ListNode cur = start;
        ListNode prev = pre;
        while(prev!=end){
            ListNode temp = cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        start.next=post;
        pre.next=end;
    }

     /*post = head.next;
            System.out.println(post.val);
            ListNode end = head;
            if(len%2==0){
                System.out.println(len+"--"+start.val+"--"+end.val+"--"+pre.val+"--"+post.val);
                rotate(start,end,pre,post);
            }
            head=post;
            System.out.println(len+"--"+head.val);*/
}