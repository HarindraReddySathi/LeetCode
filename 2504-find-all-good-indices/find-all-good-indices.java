class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int left=0,right=0;
        for(int i=1;i<k;i++){
            if(nums[i]<=nums[i-1])left++;
        }
        int c=1;
        for(int i=k+2;i<n && c<k;i++,c++){
            if(nums[i]>=nums[i-1])right++;
        }
        if(left==k-1 && right==k-1) ans.add(k);

        for(int i=k+1;i<n-k;i++){
            if(nums[i-1]<=nums[i-2])left++;
            if(nums[i]<=nums[i+1])right--;
            if(nums[i-k]<=nums[i-k-1]) left--;
            if(nums[i+k]>=nums[i+k-1]) right++;
            if(left==k-1 && right==k-1) ans.add(i);
        }
        return ans;
    }
}