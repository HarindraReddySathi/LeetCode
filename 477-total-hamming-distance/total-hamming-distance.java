class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int[][] set = new int[31][2];

        for(int num : nums){
            int bit =0;
            while(bit<=30){
                int cur = num&1;
                set[bit][cur]++;
                num = num>>1;
                bit++;
            }
        }

        int ans =0;
        for(int[] i : set){
            ans+=(i[0]*i[1]);
        }
        return ans;
    }
}