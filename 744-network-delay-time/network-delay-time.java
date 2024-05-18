class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        /*
            -  are all the weights are positive(yes)
            -  Directed graph ? (yes)
            -  if not possible to reach n nodes return -1
            -  source of the signal is k
            - can i consider the minmum and maximum time required to reach any node will
                not cross integer limit (No - minimum will not cross but max may be)
            - nodes are numbered from 1 to n
        */

        /*

            n= 4
            start = 2 
            // Adjacency Matrix
                2 - 1(1), 3(1)
                3 - 4(1)
            lm - Maximum value of long
            [0-lm,1-1,2-0,3-1,4-2]
            queue = {2-,1-,3-,4-}

        */

        Map<Integer,List<Edge>> adjacencyList = adjacencyListBuilder(times);
        long[] maxNetworkDelayFromSrc = new long[n+1];
        Arrays.fill(maxNetworkDelayFromSrc,Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Long.compare(a.timeDelay,b.timeDelay));    
        maxNetworkDelayFromSrc[k]=0;
        pq.add(new Node(k,maxNetworkDelayFromSrc[k]));
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentNode = current.targetNode;
            //System.out.println(currentNode + " -- "+ maxNetworkDelayFromSrc[currentNode]);
            if(!adjacencyList.containsKey(currentNode)) continue;
            for(Edge edge : adjacencyList.get(currentNode)){
                int targetNode = edge.targetNode;
                int timeDelay = edge.timeDelay;
                if(maxNetworkDelayFromSrc[targetNode] > maxNetworkDelayFromSrc[currentNode]+timeDelay){
                    maxNetworkDelayFromSrc[targetNode] = maxNetworkDelayFromSrc[currentNode]+timeDelay;
                    pq.add(new Node(targetNode,maxNetworkDelayFromSrc[targetNode]));
                }
            }
        }
        long maxDelay = 0;
        for(int i =1;i<=n;i++){
            if(maxNetworkDelayFromSrc[i]==Long.MAX_VALUE){
                maxDelay =-1;
                break;
            }
            maxDelay = Math.max(maxDelay,maxNetworkDelayFromSrc[i]);
        }
        return (int)maxDelay;
    }

    public Map<Integer,List<Edge>> adjacencyListBuilder(int[][] times){
        Map<Integer,List<Edge>> adjacencyList = new HashMap<>();
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int timeDelay = edge[2];
            adjacencyList.computeIfAbsent(u, l-> new ArrayList<>()).add(new Edge(v,timeDelay));
        }
        return adjacencyList;
    }

    class Edge{
        int targetNode;
        int timeDelay;

        public Edge(int targetNode,int timeDelay){
            this.targetNode = targetNode;
            this.timeDelay = timeDelay;
        }
    }
    class Node {
        int targetNode;
        long timeDelay;

        public Node(int targetNode,long timeDelay){
            this.targetNode = targetNode;
            this.timeDelay = timeDelay;
        }
    }
}