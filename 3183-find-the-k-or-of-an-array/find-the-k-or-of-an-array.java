class Solution {
    public int findKOr(int[] nums, int k) {
        int[] bit = new int[31];
        for(int i : nums){
            int pos =0;
            while(i>0){
                bit[pos++]+=i&1;
                i=i>>1;
            }
        }
        for(int i=0;i<31;i++){
            if(bit[i]>=k)bit[i]=1;
            else bit[i]=0;
        }
        int ans =0;
        int cur =1;
        for(int i=0;i<31;i++){
            if(bit[i]==1)ans+=cur;
            cur*=2;
        }
        return ans;
    }
}