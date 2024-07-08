class Solution {
    public int findTheWinner(int n, int k) {
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++) queue.add(i);
        int stage = 0;
        while(queue.size()!=1){

            int cur = queue.poll();
            stage++;
            if(stage==k){
                stage = 0;
            }else{
                queue.add(cur);
            }
        }
        return queue.poll();
    }
}