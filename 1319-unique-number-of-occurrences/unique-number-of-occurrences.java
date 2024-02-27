class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Set<Integer> s = new HashSet<>();
        for(Integer i : map.keySet()){
            if(s.contains(map.get(i))) return false;
            s.add(map.get(i));
        }
        return true;
    }
}