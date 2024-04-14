class Solution {
    public String findLatestTime(String s) {
       StringBuilder sb = new StringBuilder();
       String[] str = s.split(":");
       char[] ch = str[0].toCharArray();
       if(ch[0]=='?' && ch[1]=='?'){
            ch[0]='1';
            ch[1]='1';
       }else if(ch[0]=='?'){
            ch[0]= (ch[1]-'0'>1)?'0':'1';
       }else if(ch[1]=='?'){
            ch[1] = (ch[0]-'0'==1)?'1':'9';
       }
       sb.append(new String(ch));
       sb.append(':');
       ch = str[1].toCharArray();
       if(ch[0]=='?') ch[0]='5';
       if(ch[1]=='?') ch[1]='9';
       sb.append(new String(ch));
       return sb.toString();
    }
}