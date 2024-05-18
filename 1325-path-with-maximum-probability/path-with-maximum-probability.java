class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int src, int des) {
        
        /*
            - No -ve probabilities
            - edges.length == succProb.length
            - Does Cycle Exist - Yes
            - can two different nodes can have how many edges between them directly(only one)
            - can an edge exist between the same node in the final path - no
        */

        /*3 edges
        start = 0
        end = 2
        0 - 1(0.5),2(0.2)
        1 - 0(0.5),2(0.5)
        2 - 0(0.2),1(0.5)

        q = { -0(0,0)-,-1(0.5,0)-,2(0.2,0),2(1.0,1)}

        0      1        2 
        0     0.5.      1.0

        {current_node,parent_node}
        */

        Map<Integer,List<double[]>> adjacencyList = new HashMap<>();
        int edgeNumber =0;
        for(int[] edge : edges){
            adjacencyList.computeIfAbsent(edge[0],l -> new ArrayList<>()).add(new double[]{edge[1],succProb[edgeNumber]});
            adjacencyList.computeIfAbsent(edge[1],l -> new ArrayList<>()).add(new double[]{edge[0],succProb[edgeNumber]});
            edgeNumber++;
        }
        double[] probFromSource = new double[n];
        PriorityQueue<int[]> nodesInWait = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        nodesInWait.add(new int[]{src,src});
        probFromSource[src]=1d;
        while(!nodesInWait.isEmpty()){
            int[] currentNode = nodesInWait.poll();
            int current = currentNode[0];
            int parent = currentNode[1];
            if(!adjacencyList.containsKey(currentNode[0])) continue;
            for(double[] node : adjacencyList.get(currentNode[0])){
                int child = (int)node[0];
                if(child==parent) continue;
                if(probFromSource[child] < probFromSource[current]*node[1]){
                    probFromSource[child]= probFromSource[current]*node[1];
                    nodesInWait.add(new int[]{child,current});
                }
            }
        }
        return probFromSource[des];
    }
}