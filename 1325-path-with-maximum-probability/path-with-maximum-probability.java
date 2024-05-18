class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int src, int des) {
        Map<Integer, List<Edge>> adjacencyList = buildAdjacencyList(edges, succProb);

        double[] maxProbFromSrc = new double[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(src);
        maxProbFromSrc[src] = 1.0;

        while (!pq.isEmpty()) {
            int currentNode = pq.poll();

            if (!adjacencyList.containsKey(currentNode)) continue;

            for (Edge edge : adjacencyList.get(currentNode)) {
                int neighborNode = edge.targetNode;
                double probability = edge.probability;

                if (maxProbFromSrc[neighborNode] < maxProbFromSrc[currentNode] * probability) {
                    maxProbFromSrc[neighborNode] = maxProbFromSrc[currentNode] * probability;
                    pq.add(neighborNode);
                }
            }
        }

        return maxProbFromSrc[des];
    }

    private Map<Integer, List<Edge>> buildAdjacencyList(int[][] edges, double[] succProb) {
        Map<Integer, List<Edge>> adjacencyList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, prob));
            adjacencyList.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, prob));
        }
        return adjacencyList;
    }

    class Edge {
        int targetNode;
        double probability;

        Edge(int targetNode, double probability) {
            this.targetNode = targetNode;
            this.probability = probability;
        }
    }
}