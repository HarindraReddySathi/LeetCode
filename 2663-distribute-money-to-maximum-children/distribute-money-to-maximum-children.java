class Solution {
    public int distMoney(int m, int c) {
        if(c>m) return -1;
        if(m<8 || m==c) return 0;
        m-=c;
        int ans = m/7;
        if(ans==c && m%7==0) return c;
        if(ans>c || (ans==c && m%7!=0)) return c-1;
        if(m%7!=3 || (m%7==3 && c-ans!=1)) return ans;
        return ans-1;
    }
}