class Solution {
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >> 1);
        int ans = n & (n+1);
        return  ans== 0;
    }
}