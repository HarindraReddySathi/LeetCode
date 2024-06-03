class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        // source - {[destination,weight]}
        Map<Integer,List<int[]>> adjList = new HashMap<>();
        for(int[] edge : edges){
            adjList.computeIfAbsent(edge[0], l-> new ArrayList<>()).add(new int[]{edge[1],edge[2]});
            adjList.computeIfAbsent(edge[1], l-> new ArrayList<>()).add(new int[]{edge[0],edge[2]});
        }
        int[] shortestPath = new int[n];
        Arrays.fill(shortestPath,-1);
        // current, currentlength, parent
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{0,0,-1});
        shortestPath[0]=0;
        while(!pq.isEmpty()){

            int[] current = pq.poll();
            int curNode = current[0];
            int curLength = current[1];
            int curParent = current[2];
            //if (curLength >= disappear[curNode]) continue;
            if (shortestPath[curNode] != -1 && shortestPath[curNode] < curLength) continue;
            if(!adjList.containsKey(curNode)) continue;
            for(int[] child : adjList.get(curNode)){
                //System.out.println(child[0]);
                if(child[0]==curParent) continue;
                int nextNode = child[0];
                int nextLength = curLength+child[1];
                if(nextLength>=disappear[nextNode] || (shortestPath[nextNode]<=nextLength && shortestPath[nextNode]!=-1))continue;
                shortestPath[nextNode]=nextLength;
                pq.add(new int[]{nextNode,nextLength,curNode});
            }
        }
        return shortestPath;
    }
}