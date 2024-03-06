class Solution {
    public int minimumLength(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        int i=0;
        int j=n-1;
        while(i<j){
            if(ch[i]!=ch[j]) break;
            char l = ch[i];
            while(i<j && ch[i]==l){
                i++;
            }
            if(i==j) return 0;
            while(i<j && ch[j]==l){
                j--;
            }
        }
        return (j-i)+1;
    }
}