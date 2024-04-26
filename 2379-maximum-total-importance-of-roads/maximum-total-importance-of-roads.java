class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        int[] nodes = new int[n];
        for(int[] i : roads){
            nodes[i[0]]++;nodes[i[1]]++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nodes){
            maxHeap.add(i);
        }
        long ans =0;
        int cur = n;
        while(!maxHeap.isEmpty()){
            ans = ans + (1l*maxHeap.poll()*cur--);
        }
        return ans;
    }
}