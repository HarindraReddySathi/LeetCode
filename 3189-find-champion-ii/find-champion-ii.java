class Solution {
    public int findChampion(int n, int[][] edges) {
        
        int[] nodes = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i : edges){
            map.computeIfAbsent(i[1],l-> new ArrayList<>()).add(i[0]);
            nodes[i[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(nodes[i]==0) q.add(i);
        }
        int ans =-1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int cur = q.poll();
                if(!map.containsKey(cur)){
                    if(ans!=-1) return -1;
                    ans =cur;
                    continue;
                }
                for(Integer j : map.get(cur)){
                    nodes[j]--;
                    if(nodes[j]==0)q.add(j);
                }
            }
        }
        return ans;
    }
}