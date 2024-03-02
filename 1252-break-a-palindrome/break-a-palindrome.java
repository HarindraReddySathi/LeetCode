class Solution {
    public String breakPalindrome(String p) {
        
        char[] ch = p.toCharArray();
        int n = ch.length;
        if(n==1) return "";
        int count=0;
        for(int i=0;i<n;i++){
            if(n%2!=0 && i==n/2) continue;
            if(ch[i]-'a'!=0){
                ch[i]='a';
                count++;
                break;
            }
        }
        if(count==0)ch[n-1]='b';
        return String.valueOf(ch);
    }
}