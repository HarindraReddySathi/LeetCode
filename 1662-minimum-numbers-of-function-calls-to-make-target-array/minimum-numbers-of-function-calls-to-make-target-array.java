class Solution {
    public int minOperations(int[] nums) {
        int mul = 0;
        int add = 0;
        for(int i : nums){
            int temp =0;
            while(i>0){
                if(i%2!=0) add++;
                i=i>>1;
                if(i!=0) temp++;
            }
            mul = Math.max(mul,temp);
        }
        return mul+add;
    }
}