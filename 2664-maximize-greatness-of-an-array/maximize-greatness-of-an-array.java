class Solution {
    public int maximizeGreatness(int[] nums) {
        
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int max = -1;
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(max<map.get(i)) max = map.get(i);
        }
        return n-max;
    }
}