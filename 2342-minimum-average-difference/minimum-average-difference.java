class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        if(nums.length==1) return 0;
        long sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int min = Integer.MAX_VALUE;
        int idx =-1;
        long pre =0;
        for(int i=0; i <nums.length;i++){
            pre+=nums[i];
            int l = (int)(pre/(i+1));
            int r = (i==nums.length-1)?0:(int)((sum-pre)/(nums.length-i-1));
            //System.out.println(l+" -- "+r);
            int dec = Math.abs(l-r);
            if(min>dec){
                min = dec;
                idx = i;
            }
        }
        return idx;
    }
}