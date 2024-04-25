class Solution {
    public double trimMean(int[] arr) {
        double sum = 0;
        int n = arr.length;
        Arrays.sort(arr);
        int ig = n/20;
        for(int i = ig;i< n-ig;i++){
            sum+=arr[i];
        }
        return sum/(n-ig-ig);
    }
}