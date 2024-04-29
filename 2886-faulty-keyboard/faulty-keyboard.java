class Solution {
    public String finalString(String s) {
        
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(c=='i') sb.reverse();
            else sb.append(c+"");
        }
        return sb.toString();
    }
}