class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int n = nums.length;
        int ans =0;
        for(int i=0;i<n;i++){
            int prev = nums[i];
            if(prev ==k){
                ans++;
            }
            for(int j=i+1;j<n;j++){
                prev = gcd(prev,nums[j]);
                if(prev ==k){
                    ans++;
                }
            }
        }
        return ans;
    }

    public int gcd(int a ,int b){
        if(b<a) return gcd(b,a);
        if(a==0)return b;
        return gcd(b%a,a);
    }
}