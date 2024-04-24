class Solution {
    public int minFlips(int a, int b, int c) {
        int ans =0;
        for(int i=0;i<32;i++){
            int A = a&1;
            int B = b&1;
            int C = c&1;
            if(C==0){
                if(A!=0)ans++;
                if(B!=0)ans++;
            }else{
                if(A==0 && B==0)ans++;
            }
            a = a>>1;
            b = b>>1;
            c = c>>1;
        }
        return ans;
    }
}