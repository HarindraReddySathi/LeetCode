class Solution {
    public int myAtoi(String s) {
        
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i = removeWhiteSpaces(ch,n);
        if(i==n) return 0;
        if(ch[i]!='+' && ch[i]!='-' && ch[i]-'0'<0 && ch[i]-'9'>0) return 0;
        if(ch[i]=='-') sb.append(ch[i++]);
        else if(ch[i]=='+') sb.append(ch[i++]);
        while(i<n&&(ch[i]-'0'>=0&&ch[i]-'0'<10)){
            sb.append(ch[i++]);
        }
        if(sb.length()==0 ||(sb.length()==1 && (sb.charAt(0)=='+' || sb.charAt(0)=='-'))) return 0;
        System.out.println(sb.toString());
        double ans = Double.parseDouble(sb.toString());
        if(ans<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(ans>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)ans;
    }

    public int removeWhiteSpaces(char[] ch ,int n){

        for(int i=0;i<n;i++){
            if(ch[i]!=' ') return i;
        }
        return n;
    }

}