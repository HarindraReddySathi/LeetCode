class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
        int n = tasks.length;
        Map<Integer,Long> map = new HashMap<>();
        long day =1;
        for(int i =0;i<n;i++){
            if(map.containsKey(tasks[i])){
                long lastDay = map.get(tasks[i]);
                if(lastDay+space>=day){
                    day = lastDay+space+1;
                }
            }
            map.put(tasks[i],day);
            day++;
        }
        return day-1;
    }
}