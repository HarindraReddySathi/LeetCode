class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        int ans =0;
        // To Calculate odd length palindromes
        for(int i=0;i<n;i++){
            int j=i;
            int k=i;
            while(j>=0 && k<n && ch[j]==ch[k]){
                ans++;
                j--;
                k++;
            }
        }
        // To Calculate even length palindromes
        for(int i=1;i<n;i++){
            if(ch[i]!=ch[i-1]) continue;
            int j=i-1;
            int k=i;
            while(j>=0 && k<n && ch[j]==ch[k]){
                ans++;
                j--;
                k++;
            }
        }
        return ans;
    }
}