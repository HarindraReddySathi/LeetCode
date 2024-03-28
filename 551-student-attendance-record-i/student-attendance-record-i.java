class Solution {
    public boolean checkRecord(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int absent =0;
        int late =0;
        for(char c : ch){
            if(c=='A'){
                late=0;
                absent++;
                if(absent>=2) return false;
            }else if(c=='L'){
                late++;
                if(late>=3) return false;
            }else{
                late=0;
            }
        }
        return true;
    }
}