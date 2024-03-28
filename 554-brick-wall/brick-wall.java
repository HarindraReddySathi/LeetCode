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
                if(size==l.size()-1) continue;
                sum+=i;
                int val = map.getOrDefault(sum,0)+1;
                map.put(sum,val);
                if(max<val)max=val;
                size++;
            }
        }
        return n-max;
    }
}