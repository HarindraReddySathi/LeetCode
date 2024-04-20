class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        // Check bombs within range of eachother 
        for (int i = 0; i < bombs.length - 1; i++) {
            for (int j = 1; j < bombs.length; j++) {   
                double distance = calculateDistance(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]);
                if (distance <= bombs[i][2])
                    graph.get(i).add(j);
                if (distance <= bombs[j][2])
                    graph.get(j).add(i);
            }
        }

        int maxDetonationsFromSingleSource = 0;
        Set<Integer> detonated = new HashSet<>();

        for (int i = 0; i < bombs.length; i++) {
            detonated.clear();
            dfs(i, detonated, graph);
            maxDetonationsFromSingleSource = Math.max(maxDetonationsFromSingleSource, detonated.size());
            if (maxDetonationsFromSingleSource == graph.size())
                return maxDetonationsFromSingleSource;
        }

        return maxDetonationsFromSingleSource;
    }

    private double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private void dfs(int node, Set<Integer> detonated, Map<Integer, ArrayList<Integer>> graph) {
        detonated.add(node);
        for (int nextNode : graph.get(node)) {
            if (!detonated.contains(nextNode))
                dfs(nextNode, detonated, graph);
        }
    }
}