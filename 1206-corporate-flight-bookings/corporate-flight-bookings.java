class Solution {
    public int[] corpFlightBookings(int[][] b, int n) {
         int[] ans = new int[n];
        for(int i=0;i<b.length;i++){
            // ans[b[i][0]-1] += b[i][2];
            // ans[b[i][1]-1] += b[i][2];
            for(int j=b[i][0];j<=b[i][1];j++){
                ans[j-1] += b[i][2];
            }
        }
        return ans;
    }
}