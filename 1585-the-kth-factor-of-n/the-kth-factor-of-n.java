class Solution {
    public int kthFactor(int n, int k) {
        if(k==1) return 1;
        int res=1;
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                res++;
                if(res==k) return i;
            }
        }
        if(res==k-1) return n;
        return -1;
    }
}