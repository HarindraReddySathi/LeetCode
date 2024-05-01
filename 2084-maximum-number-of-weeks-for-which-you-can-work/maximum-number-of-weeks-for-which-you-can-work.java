class Solution {
    public long numberOfWeeks(int[] milestones) {
        
        long sum =0;
        int[] max = new int[2];
        for(int i : milestones){
            sum+=i;
            if(i>max[0]){
                max[1]=max[0];
                max[0]=i;
            }else if(i>max[1]){
                max[1]=i;
            }
        }
        if((max[0]==max[1])|| (sum-max[0]>=max[0])) return sum;
        return 2l*(sum-max[0])+1;
    }
}