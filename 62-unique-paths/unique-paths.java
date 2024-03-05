class Solution {
    public int uniquePaths(int m, int n) {
        
        if(m==1 || n==1) return 1;
        int[] pre = new int[n];
        Arrays.fill(pre,1);
        int[] cur = new int[n];
        for(int i=1;i<m;i++){
            cur[0]=1;
            for(int j=1;j<n;j++){
                cur[j]=cur[j-1]+pre[j];
            }
            pre=cur;
            cur = new int[n];
        }
        return pre[n-1];
    }
}