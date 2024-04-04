class Solution {
    public int maxDepth(String s) {
        int ans =0,count=0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(char c : ch){
            if(c=='('){
                count++;
                ans = Math.max(count,ans);
            }else if(c==')') count--;
        }
        return ans;
    }
}