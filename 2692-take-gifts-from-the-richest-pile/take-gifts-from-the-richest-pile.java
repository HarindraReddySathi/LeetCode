class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        long total =0l;
        for(int i : gifts){
            maxHeap.add(i);
            total+=i;
        }
        long ans =0;
        for(int i=0;i<k;i++){
            int p = maxHeap.poll();
            int q = (int)Math.floor(Math.sqrt(p));
            ans+=(p-q);
            maxHeap.add(q);
        }
        return total-ans;
    }
}