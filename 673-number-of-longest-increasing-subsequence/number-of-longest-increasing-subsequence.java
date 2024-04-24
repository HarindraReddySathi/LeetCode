class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        int[][] memo = new int[n][2];
        for(int j=0;j<2;j++){
            for(int i=0;i<n;i++){
                memo[i][j] =1;
            }
        }
        int max =1;
        int ans =0;
        for(int i=0;i<n;i++){
            for(int j =0;j<i;j++){
                if(nums[j]>=nums[i]) continue;
                if(memo[j][0]+1>memo[i][0]){
                    memo[i][0]=memo[j][0]+1;
                    memo[i][1]=memo[j][1];
                }else if(memo[j][0]+1==memo[i][0]){
                    memo[i][1]+=memo[j][1];
                }
            }
            if(max<memo[i][0]){
                max = memo[i][0];
                ans = memo[i][1];
            }else if(max == memo[i][0]){
                ans+=memo[i][1];
            }
        }
        return ans;
    }
}