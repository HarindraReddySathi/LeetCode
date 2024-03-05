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
            char r = ch[j];
            while(i<j && ch[j]==r){
                j--;
            }
            if(r==ch[j]) j--;
        }
        System.out.println(j+"--"+i);
        return (j-i)+1;
    }
}