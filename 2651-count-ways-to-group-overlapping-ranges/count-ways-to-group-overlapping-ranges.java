class Solution {
    public int mod = 1000000007;
    public int countWays(int[][] ranges) {
        int n = ranges.length;
        Arrays.sort(ranges, (a,b) -> a[0]-b[0]);
        int count =1;
        int ans =2;
        int start = ranges[0][0];
        int end = ranges[0][1];
        for(int i=1;i<n;i++){
            int[] cur = ranges[i];
            if(cur[0] > end) {
                count++;
                ans = (ans*2)%mod;
                start = cur[0];
                end = cur[1];
                continue;
            }
            end = Math.max(end, cur[1]);
        }
        return ans;

    }
}