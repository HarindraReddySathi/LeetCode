class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int[] value = new int[51];
        for(int i : nums){
            value[i]++;
        }
        int ans =0;
        for(int i=1;i<=50;i++){
            if(value[i]==2) ans^=i;
        }
        return ans;
    }
}