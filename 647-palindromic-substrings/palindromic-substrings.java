class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        int ans =1;
        for(int i=1;i<n;i++){
            ans+=findPalindromeCouunt(ch,i,n);
        }
        return ans;
    }

    public int findPalindromeCouunt(char[] ch ,int i,int n){
        int ans =0;
        ans+=Case(ch,i,i,n);
        ans+=Case(ch,i-1,i,n);
        return ans;
    }
    public int Case(char[] ch, int left,int right,int n){
        int ans =0;
        while(left>=0 && right<n){
            if(ch[left--]==ch[right++]) ans++;
            else break;
        }
        return ans;
    }
}