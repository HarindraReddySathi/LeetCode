class Solution {
    public int maxValue(int[][] events, int k) {
        
        int n = events.length;
        Arrays.sort(events,(a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int ans =0;
        int[] kScore = new int[k+1];
        Arrays.fill(kScore,-1);
        kScore[0]=0;
        for(int i =0;i<n;i++){
            while(!minHeap.isEmpty() && minHeap.peek()[0]<events[i][0]){
                int[] pcore = minHeap.poll();
                if(pcore[1] > kScore[pcore[2]]){
                    kScore[pcore[2]] = pcore[1];
                }
            }
            for(int p =0;p<k;p++){
                if(kScore[p]!=-1){
                    int[] qcore = new int[3];
                    qcore[0]=events[i][1];
                    qcore[1]=kScore[p]+events[i][2];
                    qcore[2]=p+1;
                    if(qcore[2]<=k)minHeap.add(qcore);
                    if(qcore[2]<=k && qcore[1]>ans) ans = qcore[1];
                }
            }
        }
        return ans;
    }
}