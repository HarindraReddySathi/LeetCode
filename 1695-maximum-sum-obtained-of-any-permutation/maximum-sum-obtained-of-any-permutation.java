class Solution {
    public int mod = 1000000007;
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int n = nums.length;
        int re = requests.length;
        int[] arr = new int[n];
        for(int[] i : requests){
            arr[i[0]]++;
            if(i[1]+1<n) arr[i[1]+1]--;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        maxHeap.add(arr[0]);
        //System.out.println(arr[0]);
        for(int i = 1;i<n;i++){
            arr[i]+=arr[i-1];
            //System.out.println(arr[i]);
            maxHeap.add(arr[i]);
        }
        Arrays.sort(nums);
        long ans =0;
        for(int i=n-1;i>=0;i--){
            int p1 = maxHeap.poll();
            ans = (ans+((1l*p1*nums[i])%mod))%mod;
        }
        return (int)ans;
    }
}