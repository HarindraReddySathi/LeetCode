class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int possible = 26*(n-1);
        k--;
        for(int i=0;i<n;i++) {
            if(possible > k) {
                sb.append("a");
                k--;
            }
            else {
                char ch = (char)(k-possible+'a');
                sb.append(ch+"");
                k-=(k-possible+1);
            }
            possible-=26;
        }
        return sb.toString();
    }
}