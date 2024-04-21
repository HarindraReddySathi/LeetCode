class Solution {
    public int halveArray(int[] nums) {
        
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for(int i : nums){
            sum+=i;
            pq.add(1d*i);
        }
        double desired = sum/2;
        int count=0;
        while(sum>desired){
            count++;
            double cur = pq.poll();
            double hal = cur/2;
            sum-=hal;
            if(hal>0)pq.add(hal);
        }
        return count;
    }
}