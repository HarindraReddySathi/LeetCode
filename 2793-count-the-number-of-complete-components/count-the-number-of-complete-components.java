class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        int[] parent = new int[n];
        int[] size = new int[n];
        int[] edgeCount = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        Arrays.fill(size,1);
        for(int[] i : edges){
            int left = findParent(i[0],parent);
            int right = findParent(i[1],parent);

            if(left == right){
                edgeCount[left]++;
                continue;
            }

            if(size[left]>=size[right]){
                parent[right] = left;
                size[left] += size[right];
                edgeCount[left] += edgeCount[right]+1;
            }else{
                parent[left] = right;
                size[right] += size[left];
                edgeCount[right] += edgeCount[left]+1;
            }
        }

        int ans =0;
        for(int i=0;i<n;i++){
            if(parent[i]==i && isComplete(edgeCount[i],size[i])) ans++;
        } 
        return ans;
    }

    public boolean isComplete(int a, int n){
        return a == (n*(n-1)/2);
    }

    public int findParent(int i, int[] parent){
        if(parent[i]!=i){
            parent[i] = findParent(parent[i],parent);
        }
        return parent[i];
    }
}