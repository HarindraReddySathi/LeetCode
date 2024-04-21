class Solution {
    public long numberOfWays(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] build = new int[2];
        int[] suffix = new int[n];
        if(ch[n-1]=='1')build[1]++;
        if(ch[n-1]=='0')build[0]++;
        for(int i =n-2;i>=0;i--){
            int dec = ch[i]=='0' ? 1:0;
            int inc = ch[i]=='0' ? 0:1;
            suffix[i]= build[dec];
            build[inc]++;
        }
        long ans =0;
        long[] memo = new long[2];
        for(int i =n-2;i>=0;i--){
            int dec = ch[i]=='0' ? 0:1;
            int inc = ch[i]=='0' ? 1:0;
            ans+=memo[inc];
            memo[dec]+=suffix[i];
        }
        return ans;
    }
}