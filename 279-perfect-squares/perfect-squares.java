class Solution {

    public int numSquares(int n) {
        List<Integer> sq = getSquares(n);
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[n+1];
        isVisited[0]=true;
        q.add(0);
        int level =1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int p=0;p<size;p++){
                int curr = q.poll();
                for(Integer i : sq){
                    if(curr+i==n) return level;
                    if(curr+i>n || isVisited[curr+i])continue;
                    q.add(curr+i);
                    isVisited[curr+i]=true;;
                }
            }
            level++;
        }
        return -1;
    }

    public List<Integer> getSquares(int n){
        int i=1;
        List<Integer> ans = new ArrayList<>();
        while(i*i<=n){
            ans.add(i*i);
            i++;
        }
        return ans;
    }
}