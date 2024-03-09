class Solution {
    public int countLatticePoints(int[][] circles) {
        int ans =0;
        for(int i =0;i<201;i++){
            for(int j =0;j<201;j++){
                for(int k = 0;k<circles.length;k++){
                    int r = circles[k][2]*circles[k][2];
                    int x = (circles[k][0]-i)*(circles[k][0]-i);
                    int y = (circles[k][1]-j)*(circles[k][1]-j);
                    if(x+y<=r){
                        ans++;break;
                    }
                }
            }
        }
        return ans;
    }
}