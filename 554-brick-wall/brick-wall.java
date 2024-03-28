class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = wall.size();
        int max = 0;
        int sum =0;
        for(List<Integer> l : wall){
            sum=0;
            int size =0;
            int end = l.size()-1;
            for(Integer i : l){
                if(size==end) continue;
                sum+=i;
                map.put(sum,map.getOrDefault(sum,0)+1);
                max = Math.max(max,map.get(sum));
                size++;
            }
        }
        return n-max;
    }
}