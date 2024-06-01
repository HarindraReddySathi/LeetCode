class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i=1;i<n+1;i++)parent[i]=i;
        int[] size = new int[n+1];
        Arrays.fill(size,1);
        int[] result = new int[2];
        for(int[] edge : edges){
            int left = edge[0],right = edge[1];
            int leftSize =0,rightSize=0;
            while(parent[left]!=left){
                parent[left]=parent[parent[left]];
                left = parent[parent[left]];
            }
            leftSize = size[left];
            while(parent[right]!=right){
                parent[right]=parent[parent[right]];
                right = parent[parent[right]];
            }
            rightSize = size[right];
            if(left==right){
                result = edge;
                continue;
            }
            if(leftSize>=rightSize){
                parent[right]= left;
                size[left]+=size[right];
            }else{
                parent[left]= right;
                size[right]+=size[left];
            }
        }
        return result;
    }
}