class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        if(k==0) return 1;

        int[] count = new int[31];
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int cur=0;
        int i=0,j=0;
        while(i<n){
            while(j<n && cur<k){
                cur = update(cur,nums[j],0,count);
                j++;
            }
            System.out.println(i+" - "+j+" - "+cur);
            if(j==n && cur<k) break;
            if(cur>=k)ans= Math.min(ans,(j-i));
            if(ans==1) return 1;
            cur = update(cur,nums[i],1,count);
            i++;
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }

    public int update(int cur,int p,int IorD,int[] count){
        int fac =1;
        int stage=0;
        while(stage<31){
            int curbit = p&1;
            if(curbit==1){
                if(IorD==0 && count[stage]==0) cur+=fac;
                if(IorD==0)   count[stage]++;
                if(IorD==1)count[stage]--;
                if(IorD==1 && count[stage]==0) cur-=fac;
            }
            fac*=2;
            stage++;
            p=p>>1;
            if(p==0) break;
        }
        return cur;
    }
}