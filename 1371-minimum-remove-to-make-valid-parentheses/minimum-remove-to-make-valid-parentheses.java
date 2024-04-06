class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int close = 0;
        for(char c : ch){
            if(c==')') close++;
        }
        int count =0;
        for(char c : ch){
            if(c=='('){
                if(close>0){
                    sb.append(c);
                    close--;
                    count++;
                }
            }else if(c==')'){
                if(count>0){
                    sb.append(c);
                    count--;
                }else{
                    close--;
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}