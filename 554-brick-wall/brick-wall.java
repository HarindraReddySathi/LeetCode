class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = wall.size();
        int min = n;
        int sum =0;
        for(List<Integer> l : wall){
            sum=0;
            for(Integer i=0;i<l.size()-1;i++){
                sum+=l.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
                min = Math.min(min,(n-map.get(sum)));
            }
        }
        /*for(Integer i : map.keySet()){
            if(i==sum) continue;
            min = Math.min(min,(n-map.get(i)));
        }*/
        return min;
    }
}