class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        Set<Integer> set  = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        while(set.contains(original)){
            original*=2;
        }
        return original;
    }
}