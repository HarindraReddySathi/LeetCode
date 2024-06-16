class Solution {
    public int numberOfChild(int n, int k) {
        int rem = k%(n-1);
        int round = k/(n-1);
        if(round%2==0){
            return rem;
        }else{
            return n-1-rem;
        }
    }
}