class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n==1){
            ans.add(0);
            return ans;
        } 
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] isVisited = new int[n];
        for(int[] i : edges){
            map.computeIfAbsent(i[0],l->new ArrayList<>()).add(i[1]);
            map.computeIfAbsent(i[1],l->new ArrayList<>()).add(i[0]);
        }
        for(int[] i : edges){
            isVisited[i[0]]++;
            isVisited[i[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int count = n;
        for(int i=0;i<n;i++){
            if(isVisited[i]==1){
                q.add(i);
                isVisited[i]--;
                count--;
            }
        }
        while(!q.isEmpty() && count>0){
            int size = q.size();
            for(int j =0;j<size;j++){
                int cur = q.poll();
                for(int i : map.get(cur)){
                    if(isVisited[i]==0) continue;
                    isVisited[i]--;
                    if(isVisited[i]==1){
                        q.add(i);
                        isVisited[i]--;
                        count--;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        
        return ans;
    }
}