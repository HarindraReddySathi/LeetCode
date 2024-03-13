class Solution {
    public long flowerGame(int n, int m) {
        int dec = (n%2==0)?0:1;
        int e1 = n/2;
        int o1 = n/2+dec;
        dec = (m%2==0)?0:1;
        int e2 = m/2;
        int o2 = m/2+dec;
        long ans = 1l*e1*o2+1l*e2*o1;
        return ans;
    }
}