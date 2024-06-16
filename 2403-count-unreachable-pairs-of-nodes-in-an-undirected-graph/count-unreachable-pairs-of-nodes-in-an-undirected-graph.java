class Solution {
    public long countPairs(int n, int[][] edges) {
        

        int[] parent = new int[n];
        int[] size = new int[n];
        Arrays.fill(size,1);
        for(int i =0;i<n;i++) parent[i]=i;

        for(int[] edge : edges){
            int left = findParent(edge[0],parent);
            int right = findParent(edge[1],parent);
            if(right == left) continue;
            if(size[left]>=size[right]){
                parent[right] = left;
                size[left] += size[right];
            }else{
                parent[left] = right;
                size[right] += size[left];
            }
        }

        long pairs = (1l*n*(n-1))/2;

        for(int i =0;i<n;i++){
            if(parent[i]==i){
                //System.out.println(i +" -- "+ size[i]);
                int k = size[i];
                pairs -= (1l*k*(k-1))/2;
            }
        }

        return pairs;
    }

    public int findParent(int i , int[] parent){
        if(parent[i]!=i){
            parent[i] = findParent(parent[i],parent);
        }
        return parent[i];
    }
}