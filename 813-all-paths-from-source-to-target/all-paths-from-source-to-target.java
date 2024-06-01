class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int n = graph.length;
        List<List<Integer>> allPossiblePaths = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        queue.add(cur);
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur.get(cur.size()-1)==n-1) allPossiblePaths.add(cur);
            for(int i : graph[cur.get(cur.size()-1)]){
                List<Integer> next = new ArrayList<>(cur);
                next.add(i);
                queue.add(next);
            }
        }
        return allPossiblePaths;
    }
}