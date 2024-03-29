class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[] diff = new int[2];
        int pos =0;
        for(int i=0;i<n;i++){
            if(ch1[i]==ch2[i]) continue;
            if(pos>=2) return false;
            diff[pos++]=i;
        }
        if(pos==0) return true;
        if(pos==1) return false;
        if(ch1[diff[0]]==ch2[diff[1]] && ch1[diff[1]]==ch2[diff[0]]) return true;
        return false;
    }
}