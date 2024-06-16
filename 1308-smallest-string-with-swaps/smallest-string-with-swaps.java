class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] parent = new int[n];
        int[] size = new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;

        for(List<Integer> pair : pairs){
            
            int left = findParent(pair.get(0),parent);
            int right = findParent(pair.get(1),parent);

            if(size[left]>=size[right]){
                parent[right] = left;
                size[left]+=size[right];
            }else{
                parent[left] = right;
                size[right]+=size[left];
            }

        }

        Map<Integer,PriorityQueue<Character>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int root = findParent(i,parent);
            map.computeIfAbsent(root, pq -> new PriorityQueue<>()).add(ch[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(map.get(parent[i]).poll()+"");
        }
        return sb.toString();
    }

    public int findParent(int i ,int[] parent){
        if(parent[i]!=i){
            parent[i] = findParent(parent[i],parent);
        }
        return parent[i];
    }
}