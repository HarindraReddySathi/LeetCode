class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        int ans =0;
        if(k==0){
            for(int i : m.keySet()){
                if(m.get(i)>1)
                ans+=1;
            }
            return ans;
        }
        for(int i : m.keySet()){
            if(m.containsKey(i+k)){
                ans=ans+1;//(m.get(i)*m.get(i+k));
            }
            if(m.containsKey(i-k)){
                ans=ans+1;//(m.get(i)*m.get(i-k));
            }
        }
        ans=ans/2;
        return ans;
    }
}