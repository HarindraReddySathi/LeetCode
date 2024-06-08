class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);
        int prev =0;
        for(int i =0;i<nums.length;i++){
            prev += nums[i];
            prev = prev%k;
            if(map.containsKey(prev)){
                if(i-map.get(prev)>1) return true;
            }else{
                map.put(prev,i);
            }
        }
        return false;
    }
}