class Solution {
    public List<Integer> findDuplicates(int[] nums) {
      List<Integer> res = new ArrayList<>();
      int n = nums.length;
      for(int i=0;i<n;i++){
        if(nums[Math.abs(nums[i])-1]<0) res.add(Math.abs(nums[i]));
        nums[Math.abs(nums[i])-1]*=-1;
      }
      return res;
    }
}