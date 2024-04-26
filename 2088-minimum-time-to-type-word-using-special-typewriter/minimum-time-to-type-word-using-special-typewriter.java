class Solution {
    public int minTimeToType(String word) {
        
        int ans =0;
        char[] ch = word.toCharArray();
        int n = ch.length;
        int prev = (int)'a';

        for(int i=0;i<n;i++) {
            int diff = (int)Math.abs(ch[i]-prev);
            if(diff < 26-diff) {
                ans+=diff;
            }
            else {
                ans+=26-diff;
            }
            ans++;
            prev = ch[i];
        }
        return ans;
    }
}