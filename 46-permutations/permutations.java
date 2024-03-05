class Solution {
    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[n];
        int[] comb = new int[n];
        DFS(nums, n, ans, isVisited, comb, 0);
        return ans;
    }

    public void DFS(int[] nums, int n, List<List<Integer>> ans,
     boolean[] isVisited, int[] comb, int level){
         if(level==n){
             update(comb,ans);
             return;
         }
         for(int i=0;i<n;i++){
            if(isVisited[i]) continue;
            isVisited[i]=true;
            comb[level]=nums[i];
            DFS(nums, n, ans, isVisited, comb, level+1);
            isVisited[i]=false;
         }
    }

    public void update(int[] comb,List<List<Integer>> ans){
        List<Integer> l = new ArrayList<>();
        for(int i:comb) l.add(i);
        ans.add(l);
    }
}