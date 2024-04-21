class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i : edges){
            if((i[0]== source && i[1]==destination)||(i[1]== source && i[0]==destination)) return true;
            map.computeIfAbsent(i[0],l->new ArrayList<>()).add(i[1]);
            map.computeIfAbsent(i[1],l->new ArrayList<>()).add(i[0]);
        }
        boolean[] isVisited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        isVisited[source] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int cur = q.poll();
                for(int j : map.get(cur)){
                    if(j==destination) return true;
                    if(isVisited[j]) continue;
                    q.add(j);
                    isVisited[j]=true;
                }
            }
        }
        return false;
    }
}