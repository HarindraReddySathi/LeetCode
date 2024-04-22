class Solution {
    public int mostWordsFound(String[] sentences) {
        
        int ans = 0;
        for(String s : sentences){
            int temp = s.split(" ").length;
            if(temp> ans) ans = temp;
        }
        return ans;
    }
}