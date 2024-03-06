class Solution {
    public boolean isPowerOfThree(int n) {
        /*if(n<1) return false;
        if(n==1) return true;
        if(n%3!=0) return false;
        return isPowerOfThree(n/3);*/
        //return n > 0 && 1162261467 % n == 0;
        return Integer.toString(n, 3).matches("^10*$");
    }
}