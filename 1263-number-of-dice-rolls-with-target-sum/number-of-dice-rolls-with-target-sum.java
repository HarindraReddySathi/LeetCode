class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        
        int MOD = 1000000007;
        long[][] dp = new long[n][target+1];

        for(int j=1;j<=target;j++){
            if(j<=k){
                dp[0][j] = 1;
            }else{
                break;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                long chances =0;
                for(int p=1;p<=k;p++){
                    if(j-p>0){
                        chances = (chances+dp[i-1][j-p])%MOD;
                    }else{
                        break;
                    }
                }
                dp[i][j] = chances;
            }
        }

        return (int)(dp[n-1][target]%(MOD));
    }
}