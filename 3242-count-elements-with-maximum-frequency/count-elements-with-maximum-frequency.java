class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;    
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
            max = Math.max(max,map.get(i));
        }
        int ans =0;
        for(int i : map.keySet()){
            if(map.get(i)==max) ans+=map.get(i);
        }
        return ans;
    }
}