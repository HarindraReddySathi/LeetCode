class Solution {
    public int mod = 1000000007;
    public int numberOfSets(int n, int k) {
        
        long[][] memo = new long[k+1][n];
        long ans =0,cur =1;
        for(int j=n-2;j>=0;j--,cur++){
            memo[1][j] = (memo[1][j+1]+cur)%mod;
        }
        for(int i =2;i<k+1;i++){
            long prev =0;
            for(int j = n-1;j>=0;j--){
                if(n-j<=i) continue;
                memo[i][j] = (prev+memo[i-1][j+1]+memo[i][j+1])%mod;
                prev = (prev+memo[i-1][j+1])%mod;
            }
        }
        return (int)(memo[k][0]%mod);
    }
}