class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        if(n==1 || n==2) return n%2;
        int ans =0;
        int[] suffix = new int[n];
        int[] prefix = new int[n];
        for(int i = n-1;i>=0;i--){
            if(i==n-1 || i==n-2)suffix[i]=nums[i];
            else suffix[i] = suffix[i+2]+nums[i];
        }
        for(int i = 0;i<n;i++){
            if(i==0 || i==1)prefix[i]=nums[i];
            else prefix[i] = prefix[i-2]+nums[i];
        }

        if(suffix[1]==suffix[2]) ans++;
        if(prefix[n-2]==prefix[n-3]) ans++;
        if(n==3){
            if(suffix[2]==prefix[0]) ans++;
            return ans;
        }
        if(prefix[0]+suffix[3]==suffix[2]) ans++;
        if(prefix[n-4]+suffix[n-1]==prefix[n-3]) ans++;
        if(n>=5){
            for(int i =2;i<=n-3;i++){
                if(prefix[i-1]+suffix[i+2]==prefix[i-2]+suffix[i+1]) ans++;
            }
        }
        return ans;
    }
}