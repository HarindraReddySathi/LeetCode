class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int targetArrivalTime = times[targetFriend][0];
        int n = times.length;
        Arrays.sort(times,(a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> available = new PriorityQueue<>();
        int currentChair =-1;
        for(int i =0;i<n;i++){

            while(!minHeap.isEmpty() && minHeap.peek()[0]<=times[i][0]){
                available.add(minHeap.poll()[1]);
            }
            int presentChair =  (!available.isEmpty()) ? available.poll() : ++currentChair;
            if(times[i][0]==targetArrivalTime) return presentChair;
            minHeap.add(new int[]{times[i][1],presentChair});
        }
        return -1;
    }
}