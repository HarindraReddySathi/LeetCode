class Solution {
    public int countLatticePoints(int[][] circles) {
        int ans =0;
        int maxX = 0;
        int maxY = 0;
        for(int k = 0;k<circles.length;k++){
            int r = circles[k][2];
            int x = (circles[k][0]+r);
            int y = (circles[k][1]+r);
            if(x>maxX) maxX=x;
            if(y>maxY) maxY=y;
        }
        for(int i =0;i<=maxX;i++){
            for(int j =0;j<=maxY;j++){
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