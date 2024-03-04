class Solution {


    public int maxArea(int[] height) {

        int n = height.length;
        int i =0;
        int j =n-1;
        int ans =0;
        while(i<j){
            int k = (j-i)*Math.min(height[i],height[j]);
            if(ans<k)ans =k;
            if(height[i]>height[j]) j--;
            else i++;
        }
        return ans;
    }

    /*
    //Brute Force
    public int maxArea(int[] height) {
        //TC-O(N^2) SC-O(1)
        // TLE
        int n = height.length;
        int ans = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int k = (i-j)*Math.min(height[i],height[j]);
                if(k>ans)ans =k;
            }
        }
        return ans;
    }*/
}