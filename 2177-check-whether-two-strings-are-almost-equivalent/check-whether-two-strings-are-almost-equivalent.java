class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] diff = new int[26];
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        for(int i=0;i<word1.length();i++) {
            diff[ch1[i]-'a']++;
            diff[ch2[i]-'a']--;
        }

        for(int i=0;i<26;i++) {
            if(diff[i] < -3 || diff[i] > 3) return false;
        }
        return true;
    }
}