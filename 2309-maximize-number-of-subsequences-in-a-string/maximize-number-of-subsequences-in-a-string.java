class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        
        char[] ch = text.toCharArray();
        int n = ch.length;
        char[] pat = pattern.toCharArray();
        long[] dec = new long[2];
        long ans =0;
        for(int i=n-1;i>=0;i--){
            if(ch[i]==pat[0]){
                ans+=dec[1];
                dec[0]++;
            }
            if(ch[i]==pat[1]){
                dec[1]++;
            }
        }
        ans+=(dec[1]>=dec[0])?dec[1]:dec[0];
        return ans;
    }
}