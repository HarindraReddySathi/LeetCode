class Solution {
    public int mod = 1000000007;
    public int numberOfSets(int n, int k) {
        
        int[][] memo = new int[k+1][n];
        int cur =1;
        for(int j=n-2;j>=0;j--,cur++){
            memo[1][j] = (memo[1][j+1]+cur)%mod;
        }
        for(int i =2;i<k+1;i++){
            int prev =0;
            for(int j = n-i-1;j>=0;j--){
                //if(n-j<=i) continue;
                prev = (prev+memo[i-1][j+1])%mod;
                memo[i][j] = (prev+memo[i][j+1])%mod;
            }
        }
        return (int)(memo[k][0]%mod);
    }
}