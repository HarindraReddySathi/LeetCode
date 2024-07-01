class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        int ans =0;
        int totalEdges = edges.length;

        int[] parentA = new int[n+1];
        int[] sizeA = new int[n+1];
        for(int i=0;i<=n;i++) parentA[i]=i;
        Arrays.fill(sizeA,1);

        for(int[] i : edges){
            if(i[0]!=3) continue;
            if(!isIncluded(i[1],i[2],parentA,sizeA)) ans++;
        }


        int[] parentB = new int[n+1];
        int[] sizeB = new int[n+1];
        for(int i=0;i<=n;i++) parentB[i]=parentA[i];
        for(int i=0;i<=n;i++) sizeB[i]=sizeB[i];

        for(int[] i : edges){
            if(i[0]!=1) continue;
            if(!isIncluded(i[1],i[2],parentA,sizeA)) ans++;

        }

        for(int[] i : edges){
            if(i[0]!=2) continue;
            if(!isIncluded(i[1],i[2],parentB,sizeB)) ans++;
        }

        int countA=0,countB=0;
        for(int i=1;i<=n;i++){
            if(parentA[i]==i) countA++;
            if(parentB[i]==i) countB++;
        }
        return (countA==1 && countB==1) ? ans : -1;
    }

    public boolean isIncluded(int leftNode, int rightNode, int[] parent, int[] size){
            
            int left = findParent(leftNode,parent);
            int right = findParent(rightNode,parent);

            if(left==right) return false;

            if(size[left]>=size[right]){
                parent[right] = parent[left];
                size[left] += size[right];
            }else{
                parent[left] = parent[right];
                size[right] += size[left];
            }
            return true;
    }


    public int findParent(int node, int[] parent){

        if(parent[node]!=node){
            parent[node] = findParent(parent[node],parent);
        }
        return parent[node];
    }
}