/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        Map<Integer,int[]> adjacency = new HashMap<>();
        Map<Integer,Integer> incoming = new HashMap<>();
        for(int[] i : descriptions){
            int[] child = new int[2];
            if(adjacency.containsKey(i[0])) child = adjacency.get(i[0]);
            child[i[2]] = i[1];
            adjacency.put(i[0],child);
            incoming.put(i[1],incoming.getOrDefault(i[1],0)+1);
            if(!incoming.containsKey(i[0])) incoming.put(i[0],0);
        }
        int currentNodeVal=0;
        for(int i : incoming.keySet()){
            if(incoming.get(i)==0){
                currentNodeVal = i;
                break;
            }
        }
        if(currentNodeVal==0) return null;
        return downTraversal(currentNodeVal,adjacency);
    }


    public TreeNode downTraversal(int currentNodeVal , Map<Integer,int[]> adjacency){

        TreeNode root = new TreeNode(currentNodeVal);
        if(!adjacency.containsKey(currentNodeVal)) return root;
        int[] child = adjacency.get(currentNodeVal);
        if(child[0]!=0) root.right = downTraversal(child[0],adjacency);
        if(child[1]!=0) root.left = downTraversal(child[1],adjacency);
        return root;
    }
}