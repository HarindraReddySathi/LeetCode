class Solution {
    public int countSeniors(String[] details) {
        
        int ans =0;
        for(String s : details){
            if((s.charAt(11)>'6') || (s.charAt(11)=='6' && s.charAt(12)!='0')) ans++;
        }
        return ans;
    }
}