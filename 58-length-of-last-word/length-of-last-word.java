class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        char[] ch = s.toCharArray();
        int n = ch.length-1;
        int ans=0;
        while(n>=0){
            if(ch[n]==' ') return ans;
            n--;
            ans++;
        }
        return ans;
    }
}