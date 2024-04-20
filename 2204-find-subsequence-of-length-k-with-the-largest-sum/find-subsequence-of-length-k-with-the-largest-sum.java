class Solution {
    Comparator<int[]> comp = new Comparator<>(){
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    };
    Comparator<int[]> comp0 = new Comparator<>(){
         public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    };
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);

        for(int i=0;i<n;i++){
            int[] tem = new int[2];
            if(pq.size() < k) {
                tem[0] = nums[i];
                tem[1] = i;
                pq.offer(tem);
            }
            else if(pq.peek()[0] < nums[i]) {
                pq.poll();
                tem[0] = nums[i];
                tem[1] = i;
                pq.offer(tem);
            }

        }
        int[][] mat = new int[pq.size()][2];
        int i =0;
        while(!pq.isEmpty()) {
            int[] te = pq.poll();
            mat[i][0] = te[0];
            mat[i][1] = te[1];
            i++;
        }
        Arrays.sort(mat, comp0);
         i =0;
        for(int[] tem : mat) {
            ans[i++] = tem[0];
        }

        return ans;
    }
}