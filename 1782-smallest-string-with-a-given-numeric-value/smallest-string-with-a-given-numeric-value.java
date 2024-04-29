class Solution {
    public String getSmallestString(int n, int k) {
        char[] c = new char[n];
        int possible = 26*(n-1);
        k--;
        for(int i=0;i<n;i++) {
            if(possible > k) {
                c[i]='a';
                k--;
            }
            else {
                c[i] = (char)(k-possible+'a');
                
                k-=(k-possible+1);
            }
            possible-=26;
        }
        return new String(c);
    }
}