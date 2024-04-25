class Solution {
    public List<Integer> goodDaysToRobBank(int[] nums, int time) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(time==0){
            for(int i=0;i<n;i++) ans.add(i);
            return ans;
        }
        int[][] memo = new int[n][2];
        int cur =0;
        for(int i=1;i<n;i++){
            if(nums[i]<=nums[i-1]){
                cur++;
            }else{
                cur=0;
            }
            if(cur>=time)memo[i][0]=1;
        }
        cur=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                cur++;
            }else{
                cur=0;
            }
            if(cur>=time)memo[i][1]=1;
        }
        for(int i=0;i<n;i++){
            if(memo[i][0]==1 && memo[i][1]==1) ans.add(i);
        }
        return ans;
    }
}