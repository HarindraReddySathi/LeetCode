class Solution {
    public String customSortString(String order, String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int[] alpha = new int[26];
        for(char c:ch){
            alpha[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()){
            if(alpha[c-'a']>0){
                for(int i=0;i<alpha[c-'a'];i++)sb.append(c);
                alpha[c-'a']=0;
            }
        }
        for(int i=0;i<26;i++){
            if(alpha[i]>0){
                for(int j=0;j<alpha[i];j++)sb.append((char)(i+'a')+"");
            }
        }
        return sb.toString();
    }
}