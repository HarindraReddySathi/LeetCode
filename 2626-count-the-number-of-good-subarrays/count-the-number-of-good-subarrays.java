class Solution {
    public long countGood(int[] nums, int k) {
        long ans =0l;
        int n = nums.length;
        int i=0,j=0;
        Map<Integer,Integer> map = new HashMap<>();
        int pair = 0;
        while(i<n && j<n){
            int p = nums[j];
            map.put(p,map.getOrDefault(p,0)+1);
            pair+= (map.get(p)-1);
            while(pair>=k){
                ans+=(n-j);
                pair-=(map.get(nums[i])-1);
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }
            j++;
        }
        return ans;
    }
}