class Solution {
    public int maximumLength(int[] nums) {
        
        int n = nums.length;
        int ans =0;

        /**
            # 0 --> Even length
            # 1 --> Odd Length  
        **/
        int[] status  = new int[2];

        for(int i=0;i<n;i++){
            nums[i] %=2;
            status[nums[i]]++;
        }

        ans = Math.max(status[0],status[1]);

        //Reset array to zero
        Arrays.fill(status,0);
        int[] statusNeeded  = new int[2];
        statusNeeded[0]=0;
        statusNeeded[1]=1;
        /**
            # 0 --> Even Started
            # 1 --> Odd Started  
        **/
        for(int i=0;i<n;i++){
            if(statusNeeded[0]==nums[i]){
                status[0]++;
                statusNeeded[0] = toggle(statusNeeded[0]);
            }
            if(statusNeeded[1]==nums[i]){
                status[1]++;
                statusNeeded[1] = toggle(statusNeeded[1]);

            }
        }
        ans = Math.max(status[0],ans);
        ans = Math.max(status[1],ans);
        return ans;
    }

    public int toggle(int a){
        if(a==0) return 1;
        return 0;
    }
}