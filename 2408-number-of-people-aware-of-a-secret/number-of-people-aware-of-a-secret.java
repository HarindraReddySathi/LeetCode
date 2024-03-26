class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        if(delay==n-1) return 2;
        long mod = 1000000007L;
        long[] shares = new long[n + 1];
        long[] forgets = new long[n + 1];
        long ans =1;
        long speaking = 0;
        if(delay<n)shares[1+delay]=1;
        if(forget<n)forgets[1+forget]=1;
        for(int i = (delay);i<=n;i++){
            speaking+=shares[i]%mod;
            speaking-=forgets[i]%mod;
            ans-=forgets[i]%mod;
            ans+=speaking%mod;
            if(i+delay<n+1)shares[delay+i]+=speaking%mod;
            if(i+forget<n+1)forgets[i+forget]+=speaking%mod;
        }
        return (int)(ans%mod);
    }
}