class Solution {
    public boolean judgeCircle(String moves) {
        int R = 0,L = 0,U = 0,D = 0;
        int n = moves.length();
        if(n%2!=0) return false;
        char[] ch = moves.toCharArray();
        for(int i=0;i<n;i++){
            if(ch[i]=='R')R++;
            else if(ch[i]=='L')L++;
            else if(ch[i]=='U')U++;
            else D++;
        }
        if(L==R && U==D) return true;
        return false;

    }
}