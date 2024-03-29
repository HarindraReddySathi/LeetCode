class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if(n==1) return String.valueOf(nums[0]);
        if(n==2) return String.valueOf(nums[0])+"/"+String.valueOf(nums[1]);
        //return "";
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(nums[0]));
        sb.append("/(");
        for(int i=1;i<n-1;i++){
            sb.append(String.valueOf(nums[i]));
            sb.append("/");
        }
        sb.append(String.valueOf(nums[n-1]));
        sb.append(")");
        return sb.toString();
    }
}