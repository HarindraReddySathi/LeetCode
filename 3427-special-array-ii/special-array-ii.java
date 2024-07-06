class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int count =0;
        int[] prefix = new int[n];
        for(int i =1;i<n;i++){
            if((nums[i]&1)==(nums[i-1]&1)) count++;
            prefix[i] = count;
        }
        boolean[] ans = new boolean[queries.length];
        int pos =0;
        for(int[] query : queries){
            ans[pos++] = (prefix[query[1]]==prefix[query[0]]) ? true : false;
        }
        return ans;
    }
}