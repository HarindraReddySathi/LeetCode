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
        int a = length(headA);
        int b = length(headB);

        ListNode temp1 = (a>=b)?headA:headB;
        ListNode temp2 = (a<b)?headA:headB;

        for(int i=0;i<Math.abs(a-b);i++){
            temp1=temp1.next;
        }
        for(int i=0;i<Math.min(a,b);i++){
            if(temp1==temp2) return temp1;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
        /*Set<ListNode> sA = new HashSet<>();
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
        return null;*/
    }

    public int length(ListNode root){
        ListNode temp = root;
        int ans =0;
        while(temp!=null){
            temp=temp.next;
            ans++;
        }
        return ans;
    }
}