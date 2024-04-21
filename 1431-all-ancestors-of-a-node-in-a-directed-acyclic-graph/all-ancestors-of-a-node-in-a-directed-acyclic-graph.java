class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++) ans.add(new ArrayList<>());
        int[][] ancestor = new int[n][n];
        int[] incoming = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i : edges){
            map.computeIfAbsent(i[0],l-> new ArrayList<>()).add(i[1]);
            incoming[i[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(incoming[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            if(!map.containsKey(cur)) continue;
            for(int i : map.get(cur)){
                incoming[i]--;
                if(incoming[i]==0) q.add(i);
                for(int j=0;j<n;j++){
                    if(ancestor[cur][j]!=0)ancestor[i][j]++;
                }
                ancestor[i][cur]++;
            }
        }
        for(int i=0;i<n;i++){
            List<Integer> l = ans.get(i);
            for(int j=0;j<n;j++){
                    if(ancestor[i][j]!=0)l.add(j);
            }
        }
        return ans;
    }
}