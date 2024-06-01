class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        Set<String> forbiddenSteps = new HashSet<>();
        int maxforbiddenStep =0;
        for(int forbiddenStep : forbidden){
            forbiddenSteps.add(forbiddenStep+"_"+0);
            forbiddenSteps.add(forbiddenStep+"_"+1);
            if(forbiddenStep>maxforbiddenStep)maxforbiddenStep=forbiddenStep;
        }
        int limit = Math.max(maxforbiddenStep+ a + b, x + b);
        if(forbiddenSteps.contains(0) || forbiddenSteps.contains(x)) return -1;

        Queue<int[]> queue = new LinkedList<>();
        //{position,numberOfBackSteps}
        queue.add(new int[]{0,0});
        forbiddenSteps.add(0+"_"+0);
        int minSteps =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] current = queue.poll();
                if(current[0]==x) return minSteps;
                if(current[0]-b <= limit && !forbiddenSteps.contains((current[0]+a)+"_"+0)){
                    queue.add(new int[]{current[0]+a,0});
                    forbiddenSteps.add((current[0]+a)+"_"+0);
                }

                if(current[1]!=1){
                    if(current[0]-b>=0 && !forbiddenSteps.contains((current[0]-b)+"_"+1)){
                        queue.add(new int[]{current[0]-b,1});
                        forbiddenSteps.add((current[0]-b)+"_"+1);
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }
}