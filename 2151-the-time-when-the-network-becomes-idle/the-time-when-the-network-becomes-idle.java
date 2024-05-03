class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        
        int n = patience.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i : edges){
            map.computeIfAbsent(i[0],l -> new ArrayList<>()).add(i[1]);
            map.computeIfAbsent(i[1],l -> new ArrayList<>()).add(i[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int level=1;
        int ans = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int cur = q.poll();
                for(int j : map.get(cur)){
                    if(patience[j]>0){
                        //System.out.println(level + " --- " + patience[j]);
                        int temp = (((level<<1)/patience[j])*patience[j])+(level<<1);
                        if((level<<1)%patience[j]==0)temp = ((((level<<1)/patience[j])-1)*patience[j])+(level<<1);
                        //System.out.println(level + " --- ");
                        if(ans<temp) ans =temp;
                        patience[j]=0;
                        q.add(j);
                    }
                }
            }
            level++;
        }
        return ans+1;
    }
}