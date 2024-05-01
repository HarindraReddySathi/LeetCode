class Solution {
    public long numberOfWeeks(int[] milestones) {
        
        long sum =0;
        int max = 0;
        for(int i : milestones){
            sum+=i;
            if(i>max){
                max=i;
            }
        }
        if(sum-max>=max) return sum;
        return ((sum-max)<<1)+1;
    }
}