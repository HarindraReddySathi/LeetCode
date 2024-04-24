class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int t = 1;
        int dum = n;
        while(dum>0){
            dum = dum >>1;
            n = n^t;
            t = t<<1;
        }
        return n;
    }
}