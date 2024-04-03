class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int  n = img[0].length;
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum =0;
                int count=0;
                for(int k=-1;k<2;k++){
                    for(int l=-1;l<2;l++){
                        int x = i+k;
                        int y = j+l;
                        if(x>=m || y>=n || x<0 || y<0) continue;
                        sum+=img[x][y];
                        count++;
                    }
                }
                ans[i][j]=sum/count;
            }
        }
        return ans;
    }
}