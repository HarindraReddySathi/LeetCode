class Solution {
    public List<Integer> goodDaysToRobBank(int[] nums, int time) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(time==0){
            for(int i=0;i<n;i++) ans.add(i);
            return ans;
        }
        int[] memo = new int[n];
        int l =0,r=0;
        int i=0,j=n-1;
        while(++i<n && --j>=0){
            if(nums[j]<=nums[j+1]){
                r++;
                if(r>=time)memo[j]++;
                if(memo[j]==2)ans.add(j);
            }else{
                r=0;
            }
            if(nums[i]<=nums[i-1]){
                l++;
                if(l>=time)memo[i]++;
                if(memo[i]==2)ans.add(i);
            }else{
                l=0;
            }
        }
        return ans;
    }
}