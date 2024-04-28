
public class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int m = nums2.length;
        int min_x = Integer.MAX_VALUE;  // Initialize min_x to the maximum possible value

        int[][] memo = new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                if(i-j>=0 && i-j<m) memo[i][j] = nums2[i-j]-nums1[i];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int col = 0;col<3;col++) {
            int prev = memo[col][col];
            int j=col;
            int count = 1;
            for(int i=col+1;i<n && j<3 && count<m;i++) {

                if(memo[i][j]==prev) {
                    count++;
                    continue;
                }
                j++;
                
            }
            if(j<3) ans=Math.min(ans,prev);
        }
        return ans;
    }

}
