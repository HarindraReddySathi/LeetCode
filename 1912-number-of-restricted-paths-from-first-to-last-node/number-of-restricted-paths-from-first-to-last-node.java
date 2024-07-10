class Solution {

    private long max = Long.MAX_VALUE;

    public int countRestrictedPaths(int n, int[][] edges) {
        

        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], i -> new ArrayList<>()).add(new int[] {edge[1],edge[2]});
            graph.computeIfAbsent(edge[1], i -> new ArrayList<>()).add(new int[] {edge[0],edge[2]});
        }

        long[] distance = new long[n+1];
        Arrays.fill(distance,max);
        distance[n]=0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[1],b[1]));
        pq.add(new long[]{n,0});

        while(!pq.isEmpty()){

            long[] cur = pq.poll();
            for(int[] child : graph.get((int)cur[0])){
                long curDist = 0l+cur[1] + child[1];
                if(curDist < distance[child[0]]){
                    distance[child[0]] = curDist;
                    pq.add(new long[]{child[0],distance[child[0]]});

                } 
            }

        }

        long[] ans = new long[n+1];
        ans[1] =1;
        pq = new PriorityQueue<>((a,b) -> Long.compare(b[1],a[1]));
        pq.add(new long[]{1,distance[1]});

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            for(int[] child : graph.get((int)cur[0])){
                if(distance[child[0]] >=  cur[1]) continue;
                //System.out.println(cur[0] + " --- "+ child[0]);
                boolean add = (ans[child[0]]==0) ? true : false;
                ans[child[0]] = (ans[child[0]]+ans[(int)cur[0]])%(1000000000+7);
                if(add){
                     pq.add(new long[]{child[0],distance[child[0]]});
                }
                
            }
        }

        /*for(long l : ans){
            System.out.println(l);
        }*/

        return (int)(ans[n]%(1000000000+7));

    }
}