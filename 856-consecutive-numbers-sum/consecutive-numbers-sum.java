class Solution {
    public int consecutiveNumbersSum(int n) {
        // if we write n as i consecutive nums starting from k
        //k+(k+1)+....+(k+i-1)=n
        //k*i+(0+1+.....+(i-1))=n
        //k*i+(i*(i-1)/2)=n
        //k=[n-(i*(i-1)/2)]/i
        // so if [n-(i*(i-1)/2)]%i==0 there exists an interger k such that sum of
        // i consecutive integers from k equals to n
        //As we know i*(i-1)/2 <=n so we can check for this from i ==1 to max 
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