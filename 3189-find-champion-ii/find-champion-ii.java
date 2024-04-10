class Solution {
    public int findChampion(int n, int[][] edges) {
        
        int[] nodes = new int[n];
        for(int[] i : edges){
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