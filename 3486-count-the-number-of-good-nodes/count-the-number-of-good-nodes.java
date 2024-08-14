class Solution {
    public int countGoodNodes(int[][] edges) {
        
        int n = edges.length+1;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            map.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
        }

        int[] ans = new int[1];

        postOrderTraversal(map,-1,0,ans);

        return ans[0];
    }

    public int postOrderTraversal( Map<Integer,List<Integer>> map,int parent,int cur,int[] ans){

        int childCount = 1;
        int branchChild = -1;
        boolean goodNode = true;
        for(int child : map.get(cur)){
            if(child==parent) continue;
            int size = postOrderTraversal(map,cur,child,ans);
            if(branchChild == -1) branchChild = size;
            if(size!=branchChild) goodNode = false;
            childCount += size;
        }
        if(goodNode)ans[0]++;
        return childCount;
    }
}