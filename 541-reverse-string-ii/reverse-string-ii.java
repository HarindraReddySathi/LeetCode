class Solution {
    public String reverseStr(String s, int k) {
        if(k==1) return s;
        char[] ch = s.toCharArray();
        int n = ch.length;
        int start=0;
        int end = start+k-1;
        while(start<n){
            reverse(ch,start,end,n);
            start = end+k+1;
            end =start+k-1;
        }
        return String.valueOf(ch);
    }

    public void reverse(char[] ch, int start,int end,int n){
        if(end>=n)end=n-1;
        while(start<end){
            char temp = ch[end];
            ch[end]=ch[start];
            ch[start]=temp;
            end--;
            start++;
        }
    }
}