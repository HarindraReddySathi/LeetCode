class Solution {
    public int maxEvents(int[][] events) {
        Comparator<int[]> c = new Comparator<>(){
            public int compare(int[] i1,int[]i2){
                if(i1[0]==i2[0]) return Integer.compare(i1[1],i2[1]);
                return Integer.compare(i1[0],i2[0]);
            }
        };
        Arrays.sort(events,c);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int max =0;
        for(int[] i : events) max = Math.max(max,i[1]);
        int ans =0;
        int idx =0;
        for(int i=1;i<=max;i++){
            while(idx<events.length && events[idx][0]==i){
                minHeap.add(events[idx][1]);
                idx++;
            }
            boolean added = false;
            while(!minHeap.isEmpty() && minHeap.peek()==i){
                added = true;
                minHeap.poll();
            }
            if(added) ans++;
            else if(!minHeap.isEmpty() && minHeap.poll()>i) ans++;
        }
        return ans;
    }
}