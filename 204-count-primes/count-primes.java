class Solution {
    public int countPrimes(int n) {
        if(n==0 || n==1) return 0;
        boolean[] primes = new boolean[n+1];
        primes[0]=true;
        primes[1]=true;
        for(int i=2;i<n+1;i++){
            if(primes[i]) continue;
            int j=2*i;
            while(j<n){
                primes[j] =true;
                j+=i;
            }
        }
        int ans =0;
        for(int i=2;i<n;i++){
            if(!primes[i]) ans++;
        }
        return ans;
    }
}