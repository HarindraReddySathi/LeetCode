class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        Set<String> set = new HashSet<>();
        int[][] prefix = new int[n][26];
        int[][] suffix = new int[n][26];
        for(int i=1;i<n;i++){
            for(int j=0;j<26;j++){
                prefix[i][j]=prefix[i-1][j];
            }
            prefix[i][ch[i-1]-'a']++;
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<26;j++){
                suffix[i][j]=suffix[i+1][j];
            }
            suffix[i][ch[i+1]-'a']++;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<26;j++){
                if(prefix[i][j]!=0 && suffix[i][j]!=0){
                    StringBuilder sb = new StringBuilder();
                    char c = (char)(j+'a');
                    sb.append(c);
                    sb.append(ch[i]);
                    sb.append(c);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();

    }
}