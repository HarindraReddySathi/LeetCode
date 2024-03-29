class Solution {
    /*public int trap(int[] height) {
        //SC -O(2n) Tc-O(3n)
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
    }*/

    public int trap(int[] height) {
        //TC -o(N) SC-O(1)
        /*
            1. if we are at point i with knowing max value to the left of it.(including i)
            2. if we are at point j with knowing max value to the right of it.(includng j)
            3. always i>=j
            4. for ith point if there exists a value that is greater than the maximum value left of it on right side of i then obviously
               the amount of water stored above ith point will only be depenedent on the max value left of it.so we can add that to ans 
               and move right.
            5. for jth point if there exists a value that is greater than the maximum value right of it on left side of j then obviously
               the amount of water stored above jth point will only be depenedent on the max value right of it.so we can add that to ans 
               and move left.
            6. So we should move right if(leftmax<rightMax) and should move left if the condition is reverse in two pointer approach
            7. Update ans in each iteration
            
        */
        int n = height.length;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int i=0;
        int j=n-1;
        int ans=0;
        while(i<=j){
            if(height[i]>leftMax)leftMax=height[i];
            if(height[j]>rightMax)rightMax=height[j];
            ans+=(leftMax<rightMax)?leftMax-height[i]:rightMax-height[j];
            if(leftMax<rightMax)i++;
            else j--;
        }
        return ans;
    }
}