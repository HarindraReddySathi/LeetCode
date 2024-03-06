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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,List<Pair>> m = new HashMap<>();
        vot(root,0,0,m);
        //even we can get the minimum and maximum from recursion instead of using another Collections.min
        int min = Collections.min(m.keySet());
        for(int i=0;i<m.keySet().size();i++){
            Collections.sort(m.get(min));
            List<Integer> l1 = new ArrayList<>();
            for(Pair p : m.get(min)){
                l1.add(p.val);
            }
            ans.add(l1);
            min++;
        }
        return ans;
    }

    public void  vot(TreeNode root,int row,int col,Map<Integer,List<Pair>> m){
        if(root==null) return;
        m.computeIfAbsent(col, k -> new ArrayList<>()).add(new Pair(root.val,row,col));
        vot(root.left,row+1,col-1,m);
        vot(root.right,row+1,col+1,m);
    }

    class Pair implements Comparable<Pair>{
        int val;
        int row;
        int col;

        public Pair(int val,int row,int col){
            this.val=val;
            this.row=row;
            this.col=col;
        }

        public int compareTo(Pair other){
            if(this.row<other.row)return -1;
            else if(this.row>other.row) return 1;
            else{
                if(this.val<=other.val) return -1;
                return 1;
            }
        }
    }
}