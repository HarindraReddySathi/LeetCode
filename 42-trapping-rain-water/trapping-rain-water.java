class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n];
        int[] postMax = new int[n];
        preMax[0]=0;
        //System.out.println(preMax[0]);
        for(int i=1;i<n;i++){
            preMax[i]=(preMax[i-1]>height[i-1])?preMax[i-1]:height[i-1];
            //System.out.println(preMax[i]);
        }
        postMax[n-1]=0;
        //System.out.println(postMax[0]);
        for(int i=n-2;i>=0;i--){
            postMax[i]=(postMax[i+1]>height[i+1])?postMax[i+1]:height[i+1];
            //System.out.println(postMax[i]);
        }

        int ans =0;
        for(int i=0;i<n;i++){
            if(Math.min(postMax[i],preMax[i])>height[i]) ans+=Math.min(postMax[i],preMax[i])-height[i];
        }
        return ans;
    }
}