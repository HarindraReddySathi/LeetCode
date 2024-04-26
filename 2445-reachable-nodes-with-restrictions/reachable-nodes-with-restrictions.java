class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        int[] nodes = new int[n];
        for(int i : restricted)nodes[i]=-1;
        if(nodes[0]==-1) return 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i : edges){
            map.computeIfAbsent(i[0],l-> new ArrayList<>()).add(i[1]);
            map.computeIfAbsent(i[1],l-> new ArrayList<>()).add(i[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int ans =1;
        q.add(0);
        nodes[0]=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int cur = q.poll();
                for(int j : map.get(cur)){
                    if(nodes[j]==1 || nodes[j]==-1) continue;
                    nodes[j]=1;
                    ans++;
                    q.add(j);
                }
            }
        }
        return ans;
    }
}