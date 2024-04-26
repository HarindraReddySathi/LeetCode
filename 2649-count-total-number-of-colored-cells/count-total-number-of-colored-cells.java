class Solution {
    public long coloredCells(int n) {
        if(n==1) return 1;
        if(n==2) return 5;
        /*long ans = 1;
        for(int i=2;i<=n;i++){
            ans+=(4*(i-1));
        }*/
        long ans = 1l*(n-1)*(4+(4*(n-1)))/2;
        return (ans+1);
    }
}