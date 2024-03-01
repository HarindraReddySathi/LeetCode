class Solution {
    public int longestMountain(int[] nums) {
        int n =nums.length;
        if(n<3) return 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<n-1;i++){
            if(nums[i]>nums[i-1]&& nums[i]>nums[i+1]){
                //System.out.println(i);
                q.add(i);
            } 
        }
        if(q.size()==0) return 0;
        int ans =0;
        while(!q.isEmpty()){
            int cur = q.poll();
            int cans = 3;
            for(int i=cur-2;i>=0;i--){
                if(nums[i]<nums[i+1])cans++;
                else break;
            }
            for(int i=cur+2;i<n;i++){
                if(nums[i]<nums[i-1])cans++;
                else break;
            }
            if(cans>ans)ans=cans;
        }
        return ans;
    }
}