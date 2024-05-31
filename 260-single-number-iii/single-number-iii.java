class Solution {
    public int[] singleNumber(int[] nums) {
        int ans =0;
        for(int i : nums) ans^=i;
        ans&=-ans;
        int[] result = new int[2];
        for(int i : nums){
            if((ans&i)==0) result[0]^=i;
            else result[1]^=i;
        }
        return result;
    }
}