class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int one =-1;
        for(int i=0;i<n;i++)if(ch[i]=='1')one++;
        ch[n-1]='1';
        for(int i=0;i<n-1;i++){
            if(one>0){
                ch[i]='1';
                one--;
            }
            else ch[i]='0';
        }
        return String.valueOf(ch);
    }
}