class Solution {
    public boolean checkValidString(String s) {
        return validate(s, '(') && validate(s, ')');
    }
    public boolean validate(String s,char op) {
        int opc = 0,cc =0, wild = 0, sz = s.length();
        int start = op == '(' ? 0 : sz - 1, dir = op == '(' ? 1 : - 1;
        for (int i = start; i >= 0 && i < sz ; i += dir){
            if (s.charAt(i) == op){
                opc++;
            }else if(s.charAt(i) == '*'){
                wild++;
            }else{
                cc++;
                if(cc>opc+wild) return false;
            }
        }
        return true;
    }
}