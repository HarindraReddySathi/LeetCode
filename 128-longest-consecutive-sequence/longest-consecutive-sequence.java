class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++){
            s.add(nums[i]);
        }
        int length =Integer.MIN_VALUE;
        for(Integer i : s){
            if(s.contains(i-1)) continue;
            int temp =1;
            while(s.contains(i+1)){
                temp++;
                i=i+1;
            }
            if(temp>length)length=temp;
        }
        return length;
    }
}