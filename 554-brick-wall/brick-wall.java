class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        int width =0;
        for(Integer i : wall.get(0)){
            width+=i;
        }
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(List<Integer> l : wall){
            int start =0;
            for(Integer i :l){
                int count=0;
                start+=i;
                if(start!=width){
                    if(map.containsKey(start)){
                        count = map.get(start);
                    }
                    map.put(start,count+1);
                    if(max<count+1){
                        max=count+1;
                    }
                }
            }
        }
        return wall.size()-max;
    }
}