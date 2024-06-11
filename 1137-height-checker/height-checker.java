class Solution {
    public int heightChecker(int[] heights) {
        
        int n = heights.length;
        int[] sortedArray = new int[n];
        for(int i=0;i<n;i++){
            sortedArray[i] = heights[i];
        }
        Arrays.sort(sortedArray);
        int ans =0;
        for(int i=0;i<n;i++){
            if(sortedArray[i] != heights[i]) ans++;
        }
        return ans;
    }
}