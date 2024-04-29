class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> ans  = new ArrayList<>();
        int[] comb = new int[k];
        DFS(ans,comb,n,0,1,k,0);
        return ans;
    }

    public void DFS(List<List<Integer>> ans,int[] comb,int n,int level,int cur,int k,int sum){
        
        if(level == k){
            if(sum == n){
                List<Integer> l = new ArrayList<>();
                for(int i : comb)l.add(i);
                ans.add(l);
            }
            return;
        }
        if(cur>9) return;
        if(sum>=n) return; 
        comb[level]=cur;
        DFS(ans,comb,n,level+1,cur+1,k,sum+cur);
        comb[level]=0;
        DFS(ans,comb,n,level,cur+1,k,sum);
    }
}