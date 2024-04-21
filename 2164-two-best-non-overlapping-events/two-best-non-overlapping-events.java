class Solution {
    Comparator<int[]> comp1 = new Comparator<>(){
        public int compare(int[] i1,int[] i2){
            return i1[0]-i2[0];
        }
    };
    Comparator<int[]> comp2 = new Comparator<>(){
        public int compare(int[] i1,int[] i2){
            return i1[1]-i2[1];
        }
    };
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(comp1);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(comp2);
        int ans = 0;
        int max  = -1;
        for(int[] i: events) { 
            pq1.add(i);
            if(i[2] > ans) ans  = i[2];
        }
        while(!pq1.isEmpty()){
            int cur = pq1.peek()[0];
            while(!pq2.isEmpty() && pq2.peek()[1] < cur){
                int[] curr = pq2.poll();
                if(max<curr[2]) max = curr[2];
            }
            while(!pq1.isEmpty() && pq1.peek()[0] == cur){
                int[] curr = pq1.poll();
                //System.out.println(curr[0]+" -- "+curr[1]+" -- "+curr[2]+" --"+max);
                if(ans<max+curr[2]) ans = max+curr[2];
                pq2.add(curr);
            }
        }
        return ans;
    }
}