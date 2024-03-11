class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,List<Integer>> freq = new TreeMap<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i :nums) map.put(i,map.getOrDefault(i,0)+1);
        for(Integer i : map.keySet()){
            freq.computeIfAbsent(map.get(i),l->new ArrayList<>()).add(i);
        }
        int pos =0;
        for(Integer i : freq.keySet()){
            Collections.sort(freq.get(i),Comparator.reverseOrder());
            for(Integer j : freq.get(i)){
                for(int x=0;x<i;x++)nums[pos++]=j;
            }
        }
        return nums;
    }
}