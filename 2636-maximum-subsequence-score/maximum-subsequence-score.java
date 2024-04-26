class Solution {
    Comparator<int[]> comp = new Comparator<>(){
        public int compare(int[] n1, int[] n2) {
            return n1[1]-n2[1];
        }
    };
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int[][] hi = new int[n][2];

        for (int i = 0; i < n; i++) {
            hi[i] = new int[]{nums1[i], nums2[i]};
        }

        Arrays.sort(hi, comp);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;

        for(int i=n-1;i>=0;i--) {
            if(i>n-k) {
                minHeap.add(hi[i][0]);
                sum+=hi[i][0];
                continue;
            }
            if(i==n-k) {
                minHeap.add(hi[i][0]);
                sum+=hi[i][0];
                ans=1l*sum*hi[i][1];
                continue;
            }
            if(hi[i][0] < minHeap.peek()) {
                continue;
            }
            sum-=minHeap.poll();
            sum+=hi[i][0];
            minHeap.add(hi[i][0]);
            if(ans< 1l*sum*hi[i][1]) ans = 1l*sum*hi[i][1];
        }
        return ans;
    }


}