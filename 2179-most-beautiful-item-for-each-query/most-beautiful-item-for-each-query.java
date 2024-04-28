class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        int n = items.length;
        Arrays.sort(items,(a,b) -> a[0]-b[0]);
        int[] beauty = new int[n];
        beauty[0]=items[0][1];
        for(int i =1;i<n;i++){
            if(items[i][1]>beauty[i-1]){
                beauty[i]=items[i][1];
            }else{
                beauty[i] = beauty[i-1];
            }
        }
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int low =0;
            int high = n-1;
            int ans =0;
            while(low<=high){
                int mid = low+((high-low)>>1);
                if(items[mid][0]<=queries[i]){
                    ans = beauty[mid];
                    low = mid+1;
                }else{
                    high = mid -1;
                }
            }
            res[i]=ans;
        }
        return res;
    }
}