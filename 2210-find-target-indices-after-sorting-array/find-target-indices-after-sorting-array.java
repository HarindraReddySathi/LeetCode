class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int tarC =0;
        int tarL =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<target)tarL++;
            if(nums[i]==target)tarC++;
        }
        int cur = tarL;
        while(tarC>0){
            ans.add(tarL);
            tarL++;
            tarC--;
        }
        return ans;
    }
}