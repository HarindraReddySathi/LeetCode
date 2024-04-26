class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int least = Integer.MAX_VALUE;
        boolean isOdd = false;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] < 0) isOdd = !isOdd;
                int temp = Math.abs(matrix[i][j]);
                sum+=temp;
                if(least> temp) least = temp;
            }
        }
        if(isOdd) sum-=2*least;
        return sum;
    }
}