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
    public ListNode mergeKLists(ListNode[] lists) {

        int n= lists.length;
        if(n==0) return null;
        //if(n==1) return lists[0];
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new ListNodeComparator());
        for(int i =0;i<n;i++){
            if(lists[i]!=null)minHeap.add(lists[i]);
        }
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            if(node.next!=null)minHeap.add(node.next);
            temp.next = node;
            temp=temp.next;
        }
        return root.next;
    }
    public class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode node1, ListNode node2) {
            return node1.val - node2.val; // Compare based on the val field
        }
    }
}