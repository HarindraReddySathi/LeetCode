class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] alpha = new int[26];
        char[] ch = s.toCharArray();
        for(char c : ch){
            alpha[c-'a']++;
        }
        int prev =-1;
        for(int i=0;i<26;i++){
            if(alpha[i]!=0 && prev!=-1 && alpha[i]!=prev) return false;
            if(alpha[i]!=0 && prev==-1) prev = alpha[i];
        }
        return true;
    }
}