class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int n = queries.length;
        int[] result = new int[n];
        int curPos =0;

        for(int[] query : queries){

            maxHeap.add(Math.abs(query[0])+Math.abs(query[1]));
            
            if(maxHeap.size()<k){
                result[curPos++] =-1;
            }else{
                if(maxHeap.size()>k) maxHeap.poll();
                result[curPos++] = maxHeap.peek();
            }
        }
        return result;
    }
}