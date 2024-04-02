class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int[] alpha = new int[256];
        Arrays.fill(alpha ,-1);
        for(int i=0;i<ch1.length;i++){
            int pos = (int)(ch1[i]);
            int val = (int)(ch2[i]);
            if(alpha[pos]==-1) alpha[pos]=val;
            else if(alpha[pos]!=val) return false;
            for(int p=0;p<256;p++){
                if(p==pos) continue;
                if(alpha[p]==val) return false;
            }

        }
        return true;
    }
}