class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        long[][] costArr = new long[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(costArr[i], Integer.MAX_VALUE);
            costArr[i][i] = 0;
        }
        int n = original.length;
        for(int i=0;i<n;i++){
            int x = original[i]-'a';
            int y = changed[i]-'a';
            if(costArr[x][y]>cost[i])costArr[x][y]=cost[i];
        }

        for(int i=0;i<26;i++)
        {
            for(int j=0;j<26;j++)
            {
                for(int k=0;k<26;k++)
                {
                    costArr[j][k]=Math.min(costArr[j][k],costArr[j][i]+costArr[i][k]);
                }
            }
        }


        long ans =0;
        int len = source.length();
        char[] chs = source.toCharArray();
        char[] cht = target.toCharArray();

        for(int i=0;i<len;i++){
            int x = chs[i]-'a';
            int y = cht[i]-'a';
            if(costArr[x][y]== Integer.MAX_VALUE) return -1l;
            if(x==y) continue;
            ans+=costArr[x][y];
        }
        return ans;
    }
}