class Solution {
    public void sortColors(int[] nums) {
        
        int[] count = new int[3];

        for(int i : nums){
            count[i]++;
        }
        int c =0;
        int pos =0;
        while(c<3){
            while(count[c]>0){
                nums[pos++]=c;
                count[c]--;
            }
            c++;
        }
    }
}