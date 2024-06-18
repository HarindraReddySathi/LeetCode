class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int n = difficulty.length;
        int m = profit.length;
        int[][] pair = new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0] = difficulty[i];
            pair[i][1] = profit[i];
        }
        Arrays.sort(pair, (a,b) -> a[0]-b[0]);
        for(int i=1;i<n;i++){
            if(pair[i][1]<pair[i-1][1]) pair[i][1]=pair[i-1][1];
        }
        int ans = 0;
        for(int i : worker){

            int low =0;
            int high = n-1;
            int temp =-1;
            while(low<=high){
                int mid = low + (high-low)/2;
                if( pair[mid][0] > i){
                    high = mid-1;
                }else{
                    temp = mid;
                    low = mid+1;
                }
            }
            if(temp ==-1) continue;
            ans+= pair[temp][1];
        }
        return ans;
    }
}