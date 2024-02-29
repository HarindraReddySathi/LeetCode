class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: time){
            i=i%60;
            map.put(i,map.getOrDefault(i,0)+1);
        }
        long ans=0;
        for(Integer i : map.keySet()){
            if(i!=0 && i!=30){
                if(map.containsKey(60-i)){
                    ans+=1l*map.get(i)*map.get(60-i);
                }
            }
        }
        ans=ans/2;
        if(map.containsKey(0)){
            ans+=1l*map.get(0)*(map.get(0)-1)/2;
        }
        if(map.containsKey(30)){
            ans+=1l*map.get(30)*(map.get(30)-1)/2;
        }
        return (int)ans;
    }
}