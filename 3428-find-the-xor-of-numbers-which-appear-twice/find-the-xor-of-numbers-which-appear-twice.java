class Solution {
    public int duplicateNumbersXOR(int[] nums) {
       long mask=0;
        int xor=0;
        for(int k:nums){
            int bit=(int)((mask>>k)&1L);
            if(bit==1){
                xor=xor^k;
            }
            mask=mask|(1L<<k);
        }
        return xor ;

    }
}