class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int src, int des) {
        Map<Integer, List<Edge>> adjacencyList = buildAdjacencyList(edges, succProb);

        double[] maxProbFromSrc = new double[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));

        pq.add(new Node(src, 1.0));
        maxProbFromSrc[src] = 1.0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.node;
            double currentProb = currentNode.probability;

            if (!adjacencyList.containsKey(current)) continue;

            for (Edge edge : adjacencyList.get(current)) {
                int neighborNode = edge.targetNode;
                double probability = edge.probability;

                if (maxProbFromSrc[neighborNode] < currentProb * probability) {
                    maxProbFromSrc[neighborNode] = currentProb * probability;
                    pq.add(new Node(neighborNode, maxProbFromSrc[neighborNode]));
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

    class Node {
        int node;
        double probability;

        Node(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }
}