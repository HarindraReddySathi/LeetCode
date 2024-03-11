class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Set<Integer>> freq = new TreeMap<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i :nums){
            map.put(i,map.getOrDefault(i,0)+1);
            //freq.computeIfAbsent(map.get(i),l->new TreeSet<>(Collections.reverseOrder())).add(i);
            //if(map.get(i)-1!=0)freq.get(map.get(i)-1).remove(i);
        }
        for(Integer i : map.keySet()){
            freq.computeIfAbsent(map.get(i),l->new TreeSet<>(Collections.reverseOrder())).add(i);
        }
        int pos =0;
        for(Integer i : freq.keySet()){
            for(Integer j : freq.get(i)){
                for(int x=0;x<i;x++)nums[pos++]=j;
            }
        }
        return nums;
    }
}