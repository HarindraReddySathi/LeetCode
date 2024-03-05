class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] ans = new int[n];
        int b = bookings.length;
        for(int i=0;i<b;i++){
            int start = bookings[i][0];
            int end = bookings[i][1];
            int val = bookings[i][2];
            ans[end-1]+=val;
            if(start-2>=0)ans[start-2]-=val;
        }
        for(int i=n-2;i>=0;i--)ans[i]+=ans[i+1];
        return ans;
    }
}