class Solution {
    public String compressedString(String word) {
        
        StringBuilder comp = new StringBuilder();
        char[] ch = word.toCharArray();
        int curCount =1;
        for(int i=1;i<ch.length;i++){
            if(ch[i]!=ch[i-1]){
                comp.append(curCount+""+ch[i-1]);
                curCount=1;
            }else{
                if(curCount==9){
                    comp.append(curCount+""+ch[i-1]);
                    curCount=1;
                }else{
                    curCount++;
                }
            }
        }
        comp.append(curCount+""+ch[ch.length-1]);
        return comp.toString();
    }
}