class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int i=0;int j=0;
        int ans =0;
        while(i<n && j<n){
            while(j<n && (!map.containsKey(nums[j]) || map.get(nums[j])<k)){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                j++;
            }
            ans = Math.max(ans,(j-i));
            map.put(nums[i],map.getOrDefault(nums[i],0)-1);
            i++;
        }
        return ans;
    }
}