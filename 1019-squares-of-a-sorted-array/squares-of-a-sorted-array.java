class Solution {
    public int[] sortedSquares(int[] nums) {
        int n= nums.length;
        int[] ans = new int[n];
        int i=0,j=n-1;
        int p = n-1;
        while(i<=j){
            int first  = Math.abs(nums[i]);
            int last = Math.abs(nums[j]);
            int curr = (first>=last)?first:last;
            //System.out.println(curr);
            if(first>=last)i++;
            else j--;
            ans[p]= (int)Math.pow(curr,2);
            p--;
        }
        return ans;
    }
}