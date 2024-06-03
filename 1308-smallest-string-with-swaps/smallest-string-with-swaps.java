class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        int[] parent = new  int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        int[] size = new int[n];
        Arrays.fill(size,1);

        for (List<Integer> pair : pairs) {
            int left = find(parent, pair.get(0));
            int right = find(parent, pair.get(1));

            if (left != right) {
                if (size[left] >= size[right]) {
                    parent[right] = left;
                    size[left] += size[right];
                } else {
                    parent[left] = right;
                    size[right] += size[left];
                }
            }
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            map.computeIfAbsent(root, k -> new PriorityQueue<>()).add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            sb.append(map.get(root).poll());
        }

        return sb.toString();
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}