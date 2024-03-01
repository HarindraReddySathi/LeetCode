class Solution {
    public int[] corpFlightBookings(int[][] b, int n) {
        int[] ans = new int[n];
        for(int i=0;i<b.length;i++){
            ans[b[i][1]-1]+=b[i][2];
            if(b[i][0]-2>=0)ans[b[i][0]-2]-=b[i][2];
        }
        for(int i=n-2;i>=0;i--){
            ans[i]+=ans[i+1];
        }
        return ans;
    }
}