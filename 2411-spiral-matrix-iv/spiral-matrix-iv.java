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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int[][] ans = new int[m][n];
        for(int[] i : ans) Arrays.fill(i,-1);
        int[] pos = new int[2];
        int[] limit = {0,m-1,0,n-1};
        while(head!=null){
            int count =0;
            int max = limit[3]-limit[2]+1;
            int i = limit[0];
            int j = limit[2];
            while(head!=null && count<max){
                ans[i][j]=head.val;
                j++;
                count++;
                head=head.next;
            }
            limit[0]++;
            if(head==null) return ans;
            count=0;
            max = limit[1]-limit[0]+1;
            i=limit[0];
            j=limit[3];
            while(head!=null && count<max){
                ans[i][j]=head.val;
                i++;
                count++;
                head=head.next;
            }
            limit[3]--;
            if(head==null) return ans;
            count=0;
            max = limit[3]-limit[2]+1;
            i=limit[1];
            j=limit[3];
            while(head!=null && count<max){
                ans[i][j]=head.val;
                j--;
                count++;
                head=head.next;
            }
            limit[1]--;
            if(head==null) return ans;
            count =0;
            max = limit[1]-limit[0]+1;
            i=limit[1];
            j=limit[2];
            while(head!=null && count<max){
                ans[i][j]=head.val;
                i--;
                count++;
                head=head.next;
            }
            limit[2]++;
            if(head==null) return ans;
        }
        return ans;
    }
}