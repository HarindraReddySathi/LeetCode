class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int count=0;
        int ans = 0;
        for(int i=0;i<n;i++){
            int dec = (nums[i]==0)?-1:1;
            count+=dec;
            if(map.containsKey(count)){
                int temp = i-map.get(count);
                ans = Math.max(temp,ans);
            }else{
                map.put(count,i);
            }
        }
        return ans;
    }
}