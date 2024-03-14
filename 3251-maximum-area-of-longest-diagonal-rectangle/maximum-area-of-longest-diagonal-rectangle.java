class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int ans = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            int length =  dimensions[i][0];
            int width =  dimensions[i][1];
            int diag = length*length+width*width;
            if(diag>max){
                max = diag;
                ans = length*width;
            }else if(diag==max){
                ans = Math.max(length*width,ans);
            }
        }
        return ans;
    }
}