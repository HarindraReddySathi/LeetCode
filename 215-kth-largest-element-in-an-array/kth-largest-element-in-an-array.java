class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(pq.size()<k) pq.add(nums[i]);
            else{
                if(nums[i]>pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        
        return pq.poll();
    }
}