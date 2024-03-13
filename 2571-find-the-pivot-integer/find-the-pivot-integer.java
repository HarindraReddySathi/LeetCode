class Solution {
    public int pivotInteger(int n) {
        long sum = n*(n+1)/2;
        for(int i=1;i<=Math.sqrt(sum);i++){
            if((sum+i)==i*(i+1)) return i;
        }
        return -1;
    }
}