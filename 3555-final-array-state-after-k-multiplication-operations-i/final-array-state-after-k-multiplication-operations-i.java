class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
        int n = nums.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int i=0;i<n;i++){
            minHeap.add(new int[]{nums[i],i});
        }

        while(k>0){
            int[] cur = minHeap.poll();
            cur[0] *= multiplier;
            minHeap.add(cur);
            k--;
        }

        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            nums[cur[1]] = cur[0];
        }

        return nums;
    }
}