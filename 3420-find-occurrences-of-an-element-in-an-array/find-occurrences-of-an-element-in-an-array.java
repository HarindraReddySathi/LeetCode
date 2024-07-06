class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int count =1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x) map.put(count++,i);
        }

        for(int i=0;i<queries.length;i++){
            queries[i] = (count<=queries[i]) ? -1 : map.get(queries[i]);
        }

        return queries;
    }
}