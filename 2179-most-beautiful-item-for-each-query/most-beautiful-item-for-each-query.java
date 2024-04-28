class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        int n = items.length;
        Arrays.sort(items,(a,b) -> a[0]-b[0]);
        for(int i =1;i<n;i++){
            if(items[i][1]<items[i-1][1]) items[i][1] = items[i-1][1];
        }
        for(int i=0;i<queries.length;i++){
            int low =0;
            int high = n-1;
            int ans =0;
            while(low<=high){
                int mid = low+((high-low)>>1);
                if(items[mid][0]<=queries[i]){
                    ans = items[mid][1];
                    low = mid+1;
                }else{
                    high = mid -1;
                }
            }
            queries[i]=ans;
        }
        return queries;
    }
}