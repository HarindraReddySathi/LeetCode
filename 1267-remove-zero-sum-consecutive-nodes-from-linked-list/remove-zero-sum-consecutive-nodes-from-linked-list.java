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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        Map<Integer,ListNode> map = new HashMap<>();
        //Map<Integer,Integer> prevSum = new HashMap<>();
        map.put(0,root);
        //prevSum(0,0);
        //int pos=0;
        int sum=0;
        while(head!=null){
            sum+=head.val;
            //pos++;
            if(map.containsKey(sum)){
                ListNode k = map.get(sum).next;
                int temp = sum+k.val;
                while(k!=head){
                    map.remove(temp);
                    k=k.next;
                    temp+=k.val;
                }
                map.get(sum).next=head.next;
            }else{
                map.put(sum,head);
            }
            head=head.next;
        }
        return root.next;
    }
}