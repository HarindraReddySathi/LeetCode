class Solution {
    Comparator<int[]> comp = new Comparator<>(){
        public int compare(int[] i1,int[] i2){
            if(i1[0]!=i2[0]){
                return i1[0]-i2[0];
            }else{
                return i1[1]-i2[1];
            }
        }
    };
    public long findScore(int[] nums) {
        long ans =0;
        int n = nums.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comp);
        for(int i =0;i<n;i++){
            int[] cur = new int[2];
            cur[0]=nums[i];cur[1]=i;
            minHeap.add(cur);
        }
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            if(nums[cur[1]]>0){
                ans+=cur[0];
                nums[cur[1]]*=-1;
                if(cur[1]-1>=0 && nums[cur[1]-1]>0)nums[cur[1]-1]*=-1;
                if(cur[1]+1<n && nums[cur[1]+1]>0)nums[cur[1]+1]*=-1;
            }
        }
        return ans;
    }
}