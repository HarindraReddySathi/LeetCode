class Solution {
    public long countBadPairs(int[] nums) {
        
        int n = nums.length;
        long ans = (1l*n*(n-1))>>1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            int cur = nums[i]-i;
            int val =0;
            if(map.containsKey(cur)){
                val = map.get(cur);
                ans-= val;
            }
            map.put(cur,val+1);
        }
        return ans;
    }
}