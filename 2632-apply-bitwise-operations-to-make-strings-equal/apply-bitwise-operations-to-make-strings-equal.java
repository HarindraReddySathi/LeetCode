class Solution {
    public boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1");
        /*if(s.equals(target)) return true;
        char[] ch1 = s.toCharArray();
        char[] ch2 = target.toCharArray();
        int n = s.length();
        int up=0;
        int down =0;
        for(int i =0;i<n;i++){
            if(ch1[i]=='1' && ch2[i]=='1') return true;
            if(ch1[i]=='0' && ch2[i]=='1') up++;
            if(ch1[i]=='1' && ch2[i]=='0') down++;
            if(up >0 && down >0) return true;
        }
        return false;*/
    }
}