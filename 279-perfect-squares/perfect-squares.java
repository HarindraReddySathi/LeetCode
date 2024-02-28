class Solution {


    public int numSquares(int n) {
        List<Integer> sq = getSquares(n);
        int[] ans = new int[n+1];
        ans[0]=0;
        int i =0;
        while(i<n){
            for(Integer s :sq){
                if((i+s<=n)&&(ans[i+s]==0 || (ans[i+s]>ans[i]+1))){
                    ans[i+s]=ans[i]+1;
                    System.out.println(i+s+"-----"+ans[i+s]);
                }
            }
            i++;
        }
        return (ans[n]==0)?-1:ans[n];
    }

    /*public int numSquares(int n) {
        List<Integer> sq = getSquares(n);
        Set<Integer> s = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(-1);
        int level =1;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==-1){
                level++;
                if(!q.isEmpty()) q.add(-1);
                continue;
            }
            for(Integer i : sq){
                if(curr+i==n) return level;
                if(s.contains(curr+i) || curr+i>n)continue;
                q.add(curr+i);
                s.add(curr+i);
            }
        }
        return -1;
    }*/

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