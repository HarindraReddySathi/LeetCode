class Solution {
    public int longestPalindrome(String[] words) {
        
        int n = words.length;
        int[][] alpha = new int[26][26];
        int ans =0;
        for(String s : words){
            int i = s.charAt(0)-'a';
            int j = s.charAt(1)-'a';
            if(alpha[j][i]>0){
                ans+=4;
                alpha[j][i]--;
            }else alpha[i][j]++;

        }
        for(int i=0;i<26;i++){
            if(alpha[i][i]>0){
                ans+=2;
                break;
            }
        }
        return ans;
    }
}