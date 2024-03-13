class Solution {
    public int pivotInteger(int n) {
        double D = n*(n+1)/2;
        D = (Math.sqrt(D));
        if(D==(int)D) return (int)D;
        return -1;
    }
}