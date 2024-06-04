class Solution {
    public int longestPalindrome(String s) {
        
        int[][] alpha = new int[26][2];
        char[] ch = s.toCharArray();
        int ans =0;
        int oddCount=0;
        for(char c : ch){
            if(c>='a' && c<='z'){
                alpha[c-'a'][0]++;
                if(alpha[c-'a'][0]==2){
                    ans+=2;
                    alpha[c-'a'][0]=0;
                    oddCount--;
                }else{
                    oddCount++;
                }
            }else{
                alpha[c-'A'][1]++;
                if(alpha[c-'A'][1]==2){
                    ans+=2;
                    alpha[c-'A'][1]=0;
                    oddCount--;
                }else{
                    oddCount++;
                }
            }
        }
        return (oddCount>0) ? ans+1 : ans;
    }
}