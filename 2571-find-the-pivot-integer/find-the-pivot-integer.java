class Solution {
    public int pivotInteger(int n) {
        double D = (Math.sqrt(n*(n+1)/2));
        if(D==(int)D) return (int)D;
        return -1;
    }
}