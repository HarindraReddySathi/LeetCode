class Solution {
    public long countBadPairs(int[] nums) {
        
        int n = nums.length;
        long ans = (1l*n*(n-1))/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            int cur = nums[i]-i;
            if(map.containsKey(cur)){
                ans-=map.get(cur);
            }
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        return ans;
    }
}