class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] ch = s.toCharArray();
        int n = s.length();

        int[][] memo = new int[n][3];
        int cur = -1;

        //while(ch[cur] != '|') {cur++;}
        int count = 0;
        for(int i=0;i<n;i++) {
            if(ch[i] == '|') {
                memo[i][2] = count;
                cur = i;
                memo[i][0] = cur;
            }
            else {
                memo[i][0] = cur;
                count++;
            }
        }
        cur = -1;
        for(int i=n-1;i>=0;i--) {
            if(ch[i] == '|') {
                cur = i;
                memo[i][1] = cur;
            }
            else {
                memo[i][1] = cur;
            }
        }
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int rc = memo[r][0];
            int lc = memo[l][1];
            
            if(lc == -1 || rc == -1 || lc > r || rc < l) res[i] = 0;
            else res[i] = memo[rc][2] - memo[lc][2];
        }
        return res;
    }
}