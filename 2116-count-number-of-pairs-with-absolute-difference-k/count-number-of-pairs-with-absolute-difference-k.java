class Solution {
    public int countKDifference(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans=0;
        for(Integer i : map.keySet()){
            
            if(k!=0){
                if(map.containsKey(i+k)){
                    ans+=(map.get(i)*map.get(i+k));
                }
                if(map.containsKey(i-k)){
                    ans+=(map.get(i)*map.get(i-k));
                }
            }else{
                ans+=(map.get(i)*map.get(i))/2;
            }
        }
        ans = (k==0)?ans:ans/2;
        return ans;
    }
}