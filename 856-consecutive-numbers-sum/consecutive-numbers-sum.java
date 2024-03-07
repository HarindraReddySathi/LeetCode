class Solution {
    public int consecutiveNumbersSum(int n) {
        //int upperLimit = (int)Math.floor(n/2);
        int ans =0;
        double i=1;
        while(i<=n){
            double k = i*(i-1)/2;
            if(k>=n) break;
            if((n-k)%i==0){
                System.out.println(i);
                ans ++;
            }
            i++;
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prev = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans =0;
        for(int i=0;i<n;i++){
            if(i==0) prev[i]=nums[i];
            else prev[i]=prev[i-1]+nums[i];
            ans+=map.getOrDefault(prev[i]-k,0);
            map.put(prev[i],map.getOrDefault(prev[i],0)+1);
        }
        return ans;
    }
}