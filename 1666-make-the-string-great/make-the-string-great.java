class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(sb.length()!=0 && (Math.abs(c-sb.charAt(sb.length()-1))==32)){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}