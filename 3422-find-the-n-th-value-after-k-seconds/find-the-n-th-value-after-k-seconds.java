class Solution {
    public static int mod = 1000000000+7;
    public int valueAfterKSeconds(int n, int k) {
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        while(k-->0){
            for(int i=1;i<n;i++){
                ans[i]= (ans[i]+ans[i-1])%mod;
            }
        }
        return ans[n-1];
    }
}