class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> maxHeap = new  PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<piles.length;i++){
            maxHeap.offer(piles[i]);
        }
        for(int i=0;i<k;i++){
            int cur = maxHeap.poll();
            cur-=(cur/2);
            if(cur!=0) maxHeap.offer(cur);
        }
        int ans =0;
        while(!maxHeap.isEmpty()){
            ans+=maxHeap.poll();
        }
        return ans;
    }
}