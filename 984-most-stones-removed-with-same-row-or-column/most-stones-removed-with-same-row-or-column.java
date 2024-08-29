class Solution {
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    edges.add(new int[]{i,j});
                }
            }
        }

        int[] parent = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        int[] size = new int[n];
        Arrays.fill(size,1);

        for(int[] edge : edges){

            int left = getParent(parent,edge[0]);
            int right = getParent(parent,edge[1]);

            if(left == right) continue;

            if(size[left]>size[right]){
                size[left]+=size[right];
                parent[right] = left;
            }else{
                size[right]+=size[left];
                parent[left] = right;
            }
        }
        /*for(int i : parent)
        System.out.println(i);
         for(int i : size)
        System.out.println(i);*/

        int max =0;

        for(int i=0;i<n;i++){
            if(parent[i]==i){
                max += size[i]-1;
            }
        }

        return max;
    }

    public int getParent(int[] parent, int i){
        if(parent[i]!=i){
            parent[i] = getParent(parent,parent[i]);
        }
        return parent[i];
    }
}