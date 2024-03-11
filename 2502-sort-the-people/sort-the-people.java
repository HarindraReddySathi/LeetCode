class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map = new TreeMap<>(Collections.reverseOrder());
        for(int i =0;i<names.length;i++){
            map.put(heights[i],names[i]);
        }
        int pos =0;
        for(Integer i : map.keySet()){
            names[pos++]=map.get(i);
        }
        return names;
    }
}