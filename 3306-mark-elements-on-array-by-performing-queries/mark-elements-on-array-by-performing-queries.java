class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int m = queries.length;
        long[] ans = new long[m];
        Map<Integer,Queue<Integer>> map = new TreeMap<>();
        boolean[] isMarked = new boolean[n];
        int marked = 0;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            map.computeIfAbsent(nums[i],l-> new LinkedList<>()).add(i);
        }
        int cur=0;
        for(int[] j : queries){
            int pos = j[0];
            int count = j[1];
            if(!isMarked[pos]){
                isMarked[pos]=true;
                sum-=nums[pos];
            }
            List<Integer> l = new ArrayList<>();
            for(Integer i : map.keySet()){
                l.add(i);
            }
            for(Integer i : l){
                while(count!=0 && map.get(i).size()!=0){
                    Queue<Integer> q = map.get(i);
                    int k = q.poll();
                    if(!isMarked[k]){
                        isMarked[k]=true;
                        sum-=nums[k];
                        count--;
                    }
                }
                if(map.get(i).size()==0)map.remove(i);
                if(count==0) break;
            }
            ans[cur++]=sum;
            if(sum==0) break;
        }
        return ans;
    }
}