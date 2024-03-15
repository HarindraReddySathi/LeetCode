class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int i :nums){
            maxHeap.offer(i);
        }
        long ans =0;
        for(int i=0;i<k;i++){
            int p = maxHeap.poll();
            ans+=p;
            maxHeap.offer((p+2)/3);
        }
        return ans;
    }
}