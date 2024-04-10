class Solution {
    public int findChampion(int n, int[][] edges) {
        
        int[] nodes = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i : edges){
            map.computeIfAbsent(i[1],l-> new ArrayList<>()).add(i[0]);
            nodes[i[1]]++;
        }
        int ans =-1;
        for(int i=0;i<n;i++){
            if(nodes[i]==0 && ans!=-1) return -1;
            else if(nodes[i]==0) ans =i;
        }
        return ans;
    }
}