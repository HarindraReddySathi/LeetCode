class Solution {
    public int alternateDigitSum(int n) {
        String val = String.valueOf(n);
        char[] ch = val.toCharArray();
        int sum=0;
        int sign =1;
        for(char c :ch){
            sum+=(sign)*((int)(c-'0'));
            sign*=-1;
        }
        return sum;
    }
}