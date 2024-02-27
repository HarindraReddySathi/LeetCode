class Solution {
    public int climbStairs(int n) {
        
        int[] m = new int[n+1];
        m[0]=1;
        for(int i=0;i<=n;i++){
            if(i+1<=n) m[i+1]+=m[i];
            if(i+2<=n) m[i+2]+=m[i];
        }
        return m[n];
    }
}