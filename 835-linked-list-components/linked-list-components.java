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
    public int numComponents(ListNode head, int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int count =0;
        boolean isStart = true;
        while(head!=null){
            if(set.contains(head.val)){
                if(isStart){
                    count++;
                    isStart = false;
                }
            }else{
                isStart = true;
            }
            head = head.next;
        }
        return count;
    }
}