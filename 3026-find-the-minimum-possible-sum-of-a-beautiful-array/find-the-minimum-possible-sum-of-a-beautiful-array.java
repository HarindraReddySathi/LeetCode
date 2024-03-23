class Solution {
    private static int mod = 1000000007;
    public int minimumPossibleSum(int n, int target) {
        long res =0;
        if(target/2>=n){
            res = 1l*n*(n+1)/2;
        }else{
            int k = target/2;
            res= 1l*k*(k+1)/2 + target;
            n =n-k-1;
            res+= 1l*n*target+1l*n*(n+1)/2;
        }
        return (int)(res%mod);
    }
}