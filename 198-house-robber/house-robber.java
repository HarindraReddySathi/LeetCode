class Solution {

    //Iterative
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] memo = new int[n+1];
        memo[1]=nums[0];
        for(int i=2;i<=n;i++){
            memo[i]=Math.max(memo[i-1],memo[i-2]+nums[i-1]);
        }
        return memo[n];
    }


    /*
    //Recurssive
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return itr(nums,n,memo);
    }

    public int itr(int[] nums,int n,int[] memo){
        if(n==1) return nums[0];
        if(n==0) return 0;
        if(memo[n]!=-1) return memo[n];
        memo[n]= Math.max(itr(nums,n-1,memo),itr(nums,n-2,memo)+nums[n-1]);
        return memo[n];
    }*/
}