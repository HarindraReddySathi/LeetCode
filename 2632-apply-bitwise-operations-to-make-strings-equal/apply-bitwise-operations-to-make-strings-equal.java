class Solution {
    public boolean makeStringsEqual(String s, String target) {
        
        //if(s.equals(target)) return true;
        //char[] ch1 = s.toCharArray();
        //char[] ch2 = target.toCharArray();
        int n = s.length();
        int up=0;
        int down =0;
        for(int i =0;i<n;i++){
            if(s.charAt(i)=='1' && target.charAt(i)=='1') return true;
            if(s.charAt(i)=='0' && target.charAt(i)=='1') up++;
            if(s.charAt(i)=='1' && target.charAt(i)=='0') down++;
            if(up >0 && down >0) return true;
        }
        if(up==0 && down==0) return true;
        return false;
    }
}