class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : gifts)maxHeap.add(i);
        long ans =0;
        for(int i=0;i<k;i++){
            int p = maxHeap.poll();
            int q = (int)Math.floor(Math.sqrt(p));
            maxHeap.add(q);
        }
        while(!maxHeap.isEmpty()){
            ans+=maxHeap.poll();
        }
        return ans;
    }
}