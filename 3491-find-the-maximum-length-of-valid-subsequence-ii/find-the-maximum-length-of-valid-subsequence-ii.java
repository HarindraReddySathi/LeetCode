class Solution {
    public int maximumLength(int[] nums, int k) {
        
        int n = nums.length;
        for(int i=0;i<n;i++){
            nums[i] %=k;
        }
        int maximumLength = 0;
        for(int j=0;j<k;j++){
            int[] status = new int[k];
            int length=0;
            for(int i=0;i<n;i++){
                int req = (k+j-nums[i])%k;
                status[nums[i]] = Math.max(status[nums[i]],status[req]+1);
                length = Math.max(status[nums[i]],length);
            }
            maximumLength = Math.max(length,maximumLength);
        }
        return maximumLength;
    }
}