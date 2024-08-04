class Solution {
    public int[] timeTaken(int[][] edges) {
        
        Map<Integer,List<Integer>> graph = new HashMap<>();

        int n = edges.length+1;
        
        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
        }

        int[][] maxStore = new int[n][4];

        DFS1(graph,0,-1,maxStore);

        DFS2(graph,0,-1,maxStore,0);

        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = Math.max(maxStore[i][0],maxStore[i][2]);
        }

        return ans;
    }

    public void DFS2(Map<Integer,List<Integer>> graph,int cur,int parent,int[][] maxStore,int max){
        
        if(parent!=-1)findTopTwo(max,maxStore,cur,parent);
        int add = cur%2==0 ? 2 :1;
        for(int neighbour : graph.get(cur)){
            if(neighbour==parent) continue;
            if(maxStore[cur][1]!=neighbour){
                DFS2(graph,neighbour,cur,maxStore,maxStore[cur][0]+add);
            }else{
                DFS2(graph,neighbour,cur,maxStore,maxStore[cur][2]+add);
            }
        }
    }

    public int DFS1(Map<Integer,List<Integer>> graph,int cur,int parent,int[][] maxStore){

        for(int neighbour : graph.get(cur)){
            if(neighbour==parent) continue;
            int present = DFS1(graph,neighbour,cur,maxStore);
            findTopTwo(present,maxStore,cur,neighbour);
        }

        if(cur%2==0) return maxStore[cur][0]+2;
        return maxStore[cur][0]+1;
    }

    public void findTopTwo(int present, int[][] maxStore, int cur,int neighbour){

        if(maxStore[cur][2]>present) return;
        if(maxStore[cur][0]>present){
            maxStore[cur][2] = present;
            maxStore[cur][3] = neighbour;
            return;
        }
        maxStore[cur][2] = maxStore[cur][0];
        maxStore[cur][3] = maxStore[cur][1];
        maxStore[cur][0] = present;
        maxStore[cur][1] = neighbour;
    }

    
}