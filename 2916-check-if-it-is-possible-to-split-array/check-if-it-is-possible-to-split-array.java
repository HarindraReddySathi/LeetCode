class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        
        if(nums.size()==1 || nums.size()==2) return true;
        int prev =0;
        for(int i : nums){
            if(i+prev>=m) return true;
            else prev =i;
        }
        return false;
    }
}