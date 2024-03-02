class Solution {
    public int minimumLength(String s) {
        
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i=0;
        int j=n-1;
        while(j>i){
            if(ch[i]!=ch[j]) break;
            if(j-i==2) return 1;
            i++;j--;
            while(j>i && ch[i]==ch[i-1])i++;
            if(i==j) return 0;
            while(j>i && ch[j]==ch[j+1])j--;
        }
        return j-i+1;
    }
}