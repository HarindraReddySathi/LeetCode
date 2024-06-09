class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prev = 0,ans=0;
        for(int i=0;i<n;i++){
            nums[i] += prev;
            nums[i] %= k;
            prev = nums[i];
            if(prev<0) prev+=k;
            System.out.println(-4%5);
            System.out.println(prev);
            map.put(prev,map.getOrDefault(prev,0)+1);
            ans += (map.get(prev)-1);
        }
        map.entrySet().stream().forEach(i -> System.out.println(i.getKey()+" --- "+ i.getValue()));
        return ans;
    }
}