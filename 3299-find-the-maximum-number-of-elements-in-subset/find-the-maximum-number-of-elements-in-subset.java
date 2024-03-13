class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> isVisited = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int ans = Integer.MIN_VALUE;
        int temp =0;
        for(Integer i : map.keySet()){
            if(!isVisited.containsKey(i)){
                if(i==1){
                    int k = map.get(i);
                    int dec = (k%2==0)?-1:0;
                    temp = k+dec;
                    isVisited.put(i,temp);
                }else{
                    temp = maximum(map,isVisited,i);
                }
                if(temp>ans)ans = temp;
            }
        }
        return ans;
    }

    public int maximum( Map<Integer,Integer> map,Map<Integer,Integer> isVisited,int i){
        if(isVisited.containsKey(i)) return isVisited.get(i);
        int ans =0;
        if(map.get(i)<2) ans=1;
        else{
            if(map.containsKey(i*i)) ans=ans+2+maximum(map,isVisited,i*i);
            else ans=ans+1;
        }
        isVisited.put(i,ans);
        return ans;
    }
}