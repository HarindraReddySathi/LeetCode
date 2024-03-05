class Solution {
    private static int mod = 1000000007;
    public int monkeyMove(int n) {
        return (int)(mod+pow(2,n)-2)%mod;
    }

    public long pow(int base,int pow){
        if(pow==0) return 1;
        if(pow==1) return base;
        long k = pow(base,pow/2);
        k=(k*k)%mod;
        if(pow%2!=0) k=(k*base) % mod;
        return k;
    }
}