class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        Map<String,Integer> map = new HashMap<>();
        map.put("UP",-n);
        map.put("DOWN",n);
        map.put("RIGHT",1);
        map.put("LEFT",-1);
        int pos = 0;
        for(String s : commands){
            pos+=map.get(s);
        }
        return pos;
    }
}