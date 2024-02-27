class Solution {
    public int maxVowels(String s, int k) {
        boolean[] alpha = new boolean[26];
        alpha['a'-'a']=true; alpha['e'-'a']=true; alpha['i'-'a']=true; alpha['o'-'a']=true; alpha['u'-'a']=true;
        int n = s.length();
        char[] ch = s.toCharArray();
        int max = 0;
        int count=0;
        for(int i=0;i<k;i++){
            if(alpha[ch[i]-'a']) count++;
        }
        max=Math.max(max,count);
        for(int i=1;i<n-k+1;i++){
            if(alpha[ch[i-1]-'a']) count--;
            if(alpha[ch[i+k-1]-'a']) count++;
            max=Math.max(max,count);
        }
        return max;
    }
}