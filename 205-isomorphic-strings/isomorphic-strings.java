class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int[] alpha = new int[256];
        Arrays.fill(alpha ,-1);
        int[] set = new int[256];
        for(int i=0;i<ch1.length;i++){
            int pos = (int)(ch1[i]);
            int val = (int)(ch2[i]);
            if(alpha[pos]==-1){
                if(set[val]!=0) return false;
                set[val] = 1;
                alpha[pos]=val;
            }else if(alpha[pos]!=val) return false;
        }
        return true;
    }
}