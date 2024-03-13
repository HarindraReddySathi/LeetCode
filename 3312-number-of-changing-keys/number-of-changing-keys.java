class Solution {
    public int countKeyChanges(String s) {
        int n = s.length();
        s=s.toUpperCase();
        char[] ch = s.toCharArray();
        int ans=0;
        for(int i=1;i<n;i++){
            if(ch[i]!=ch[i-1])ans++;
        }
        return ans;
    }
}