class Solution {
    public int maxHeightOfTriangle(int red, int blue) {

       return  Math.max(maxHeight(blue,red),maxHeight(red,blue)); 
    }

    public int maxHeight(int red, int blue){
        int curStage =1, colour =0,ans =0;
        int[] balls = new int[]{blue,red};
        while(balls[0]>=0 && balls[1]>=0){
                balls[colour] -= curStage;
                curStage++;
                if(balls[colour]>=0) ans++;
                colour = toggleColour(colour);
        }
        return ans;
    }

    public int toggleColour(int a){
        if(a==0) return 1;
        return 0;
    }
}