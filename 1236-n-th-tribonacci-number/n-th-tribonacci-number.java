class Solution {
    public int tribonacci(int n) {
        int[] memo = new int[3];
        memo[0]=0;
        memo[1]=memo[2]=1;
        if(n<3) return memo[n];
        for(int i=3;i<=n;i++){
            int cur = memo[0]+memo[1]+memo[2];
            memo[0]=memo[1];
            memo[1]=memo[2];
            memo[2]=cur;
        }
        return memo[2];
    }
}