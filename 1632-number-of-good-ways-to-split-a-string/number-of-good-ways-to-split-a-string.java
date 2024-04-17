class Solution {
    public int numSplits(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] alpha = new int[26];
        int distTotal = 0;
        for(char c : ch){
            if(alpha[c-'a']==0) distTotal++;
            alpha[c-'a']++;
        }
        int ans =0;
        int[] cur = new int[26];
        int dist = 0;
        for(int i =0;i<n-1;i++){
            if(cur[ch[i]-'a']==0) dist++;
            cur[ch[i]-'a']++;
            alpha[ch[i]-'a']--;
            if(alpha[ch[i]-'a']==0) distTotal--;
            if(dist==distTotal) ans ++;
        }
        return ans;
    }
}