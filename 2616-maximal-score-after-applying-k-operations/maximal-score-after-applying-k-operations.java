class Solution {
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++){
            maxHeap.add(nums[i]);
        }
        long ans =0;
        for(int i=0;i<k;i++){
            int p = maxHeap.poll();
            ans+=p;
            //int dec = (p%3==0)?0:1;
            maxHeap.add((p+2)/3);
        }
        return ans;
    }
}