class Solution {
    public List<Integer> goodDaysToRobBank(int[] nums, int time) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(time==0){
            for(int i=0;i<n;i++) ans.add(i);
            return ans;
        }
        int[] memo = new int[n];
        int cur =0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                cur++;
                if(cur>=time)memo[i]++;
            }else{
                cur=0;
            }
        }
        cur=0;
        for(int i=1;i<n;i++){
            if(nums[i]<=nums[i-1]){
                cur++;
                if(cur>=time)memo[i]++;
                if(memo[i]==2)ans.add(i);
            }else{
                cur=0;
            }
        }
        return ans;
    }
}