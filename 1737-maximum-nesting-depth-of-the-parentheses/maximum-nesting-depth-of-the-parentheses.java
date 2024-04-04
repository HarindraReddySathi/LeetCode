class Solution {
    public int maxDepth(String s) {
        int ans =0,count=0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(char c : ch){
            if(c=='(') count++;
            if(c==')') count--;
            if(c=='(' || c==')') ans = Math.max(count,ans);
        }
        return ans;
    }
}