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
        
        int[][] matrix = new int[m][n];

        // Initialize the matrix with -1
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }

        int pos = 0;
        int colMin = 0, colMax = n - 1;
        int rowMin = 0, rowMax = m - 1;

        while (pos < m * n && head != null) {
            // Fill the top row (left to right)
            for (int p = colMin; p <= colMax && head != null; p++) {
                matrix[rowMin][p] = head.val;
                head = head.next;
                pos++;
            }
            rowMin++;
            
            // Fill the right column (top to bottom)
            for (int p = rowMin; p <= rowMax && head != null; p++) {
                matrix[p][colMax] = head.val;
                head = head.next;
                pos++;
            }
            colMax--;
            
            // Fill the bottom row (right to left)
            for (int p = colMax; p >= colMin && head != null; p--) {
                matrix[rowMax][p] = head.val;
                head = head.next;
                pos++;
            }
            rowMax--;
            
            // Fill the left column (bottom to top)
            for (int p = rowMax; p >= rowMin && head != null; p--) {
                matrix[p][colMin] = head.val;
                head = head.next;
                pos++;
            }
            colMin++;
        }

        return matrix;
    }
}
