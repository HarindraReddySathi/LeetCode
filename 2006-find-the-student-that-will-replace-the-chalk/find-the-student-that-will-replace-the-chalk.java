class Solution {
    public int chalkReplacer(int[] ck, int k) {
        int n = ck.length;
        long[] chalk = new long[n];
        chalk[0] = ck[0];
        for(int i=1;i<n;i++){
            chalk[i] = chalk[i-1]+ck[i];
        }
        k %= chalk[n-1];

        int low =0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = low + ((high-low)>>1);
            if(chalk[mid]<=k){
                low = mid+1;
            }else{
                high = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
}