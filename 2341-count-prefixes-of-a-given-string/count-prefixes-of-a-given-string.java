class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans =0;
        for(String str : words){
            if(s.indexOf(str)==0) ans++;
        }
        return ans;
    }
}