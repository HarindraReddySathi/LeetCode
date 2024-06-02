class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        int[] parent = new int[n];
        for(int i =0;i<n;i++) parent[i]=i;
        int[] size = new int[n];
        Arrays.fill(size,1);
        int freeCables =0;
        for(int[] connection : connections){

            int left = connection[0];
            int right = connection[1];

            while(parent[left]!=left){
                parent[left]=parent[parent[left]];
                left = parent[left];
            }

            while(parent[right]!=right){
                parent[right]=parent[parent[right]];
                right = parent[right];
            }
            if(left==right) freeCables++;
            if(size[left]>=size[right]){
                parent[right]=left;
                size[left]+=size[right];
            }else{
                parent[left]=right;
                size[right]+=size[left];
            }
        }
        int min =-1;
        for(int i=0;i<n;i++){
            if(parent[i]==i)min++;
        }

        return (min>freeCables) ? -1 : min;
    }
}