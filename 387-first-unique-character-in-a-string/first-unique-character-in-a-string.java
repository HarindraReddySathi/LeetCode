class Solution {
    public int firstUniqChar(String s) {
        int[] alpha = new int[26];
        char[] ch = s.toCharArray();
        for(char c : ch){
            alpha[c-'a']++;
        }
        for(int i=0;i<ch.length;i++){
            if(alpha[ch[i]-'a']==1) return i;
        }
        return -1;
    }
}