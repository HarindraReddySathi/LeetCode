class Solution {
    public int myAtoi(String s) {
        /*
            if String is valid -
                1. we need nod consider leading zeros and white spaces
                2. if we find '-' at start it is a negative number
                3. what if the number exceeds the limit of an integer - return the extemes
            if String is invalid - 
                1. may be contains anything other than numbers,'.','-' throw some error 
                2. if '-' is not present at start then it is invalid
                3. Dont consider the number after '.' since we are storing only integer 
        */
        if("".equals(s)) return 0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        s = s.trim();
        if("".equals(s)) return 0;
        int sign = s.charAt(0)=='-' ? -1 : 1;
        s = makeValid(s);
        if("".equals(s)) return 0;
        if(s.length()>10) return (sign ==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return valueGenerator(s,sign);
    }

    public int valueGenerator(String s , int sign){
        System.out.println(sign);
        int n = s.length();
        char[] ch = s.toCharArray();
        long value = 0l;
        long cur_place_val = 1;
        for(int i =n-1;i>=0;i--,cur_place_val*=10){
            value += (1l*(int)(ch[i]-'0')*cur_place_val*sign);
            //System.out.println(value);
            if(value > Integer.MAX_VALUE) return (sign==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if(value < Integer.MIN_VALUE) return (sign==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)value;
    }

    public String makeValid(String s){
        int n = s.length();
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int start = (ch[0]=='-' || ch[0]=='+') ? 1 : 0;
        boolean isLeadingZero = true;
        for(int i =start;i<n;i++){
            if((ch[i]>'9' || ch[i]<'0')) break;
            if(ch[i]=='0' && isLeadingZero) continue;
            sb.append(ch[i]);
            if(isLeadingZero) isLeadingZero = false;
        }
        return sb.toString();
    }
}