class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2) return false;
        Map<Integer,Integer> s = new HashMap<>();
        int prevSum = 0;
        for(int i=0;i<nums.length;i++){
            nums[i]= (prevSum+nums[i])%k;
            //System.out.println(nums[i]);
            prevSum=nums[i];
            if((s.containsKey(nums[i]) && s.get(nums[i])<i-1) || (nums[i]==0 && i!=0)) return true;
            else if(!(s.containsKey(nums[i]))) s.put(nums[i],i);
        }
        return false;
    }
}