class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        if(goal==0) return zeroHandler(nums,n);
        int k = 0;
        for(int i=0;i<n;i++)if(nums[i]==1)k++;
        int[] pos = new int[k+2];
        pos[k+1]=n;pos[0]=-1;
        int p=1;
        for(int i=0;i<n;i++) if(nums[i]==1)pos[p++]=i;
        int ans =0;
        for(int i=1;i<k-goal+2;i++){
            int temp = (pos[i+goal]-pos[i+goal-1])*(pos[i]-pos[i-1]);
            ans+=temp;
        }
        return ans;
    }

    public int zeroHandler(int[] nums,int n){
        int ans =0;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count++;
            }else{
                ans+=(int)1l*count*(count+1)/2;
                count=0;
            }
        }
        ans+=(int)1l*count*(count+1)/2;
        return ans;
    }
}