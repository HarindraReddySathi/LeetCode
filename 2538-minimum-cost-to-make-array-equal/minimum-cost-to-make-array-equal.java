class Solution {
    public long minCost(int[] nums, int[] cost) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            left = Math.min(left, nums[i]);
            right = Math.max(right, nums[i]);
        }

        //long ans = getCost(nums, cost, nums[0]);
        long ans =0;


        while(left<right){
            int mid = (left+right)/2;

            // finding the cost of the left one 
            long leftCost = getCost(nums, cost,mid);
            // finding the cost of the right one 
            long rightCost = getCost(nums, cost, mid+1);

            ans = Math.min(leftCost, rightCost);

            if(leftCost>rightCost){
                left = mid+1;
            }else{
                right = mid;
            }

        }

        return ans;

    }

// function to get the cost for the nums[i] any element base case 
    public static long getCost(int[] nums, int[] cost, int base){
        long res = 0l;

        for(int i=0; i<nums.length; i++){
            // by abs difference we can get the cost
            res+= 1l*cost[i]*Math.abs(base-nums[i]);
        }

        return res;
    }
}