class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        int[] ans = new int[n];
        if(n==1) return ans;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i : edges ){
            map.computeIfAbsent(i[0],l-> new ArrayList<>()).add(i[1]);
            map.computeIfAbsent(i[1],l-> new ArrayList<>()).add(i[0]);
        }

        int[] memo = new int[n];
        boolean[] isVisited = new boolean[n];
        dfs(map,memo,isVisited,0,ans);
        second(map,memo,isVisited,0,ans,0,n);
        return ans;
    }

    public void second(Map<Integer,List<Integer>> map,int[] memo,boolean[] isVisited, int root,int[] ans,int parentScore,int n){

        isVisited[root]=false;
        if(root!=0){
            int sum = parentScore-ans[root]-memo[root]-1;
            int childCount = sum+n-memo[root]-1;
            ans[root]+=childCount;
            memo[root]=n;
        }
        for(int child : map.get(root)){
            if(!isVisited[child])continue;
            second(map,memo,isVisited,child,ans,ans[root],n);
        }
    }

    public void dfs(Map<Integer,List<Integer>> map,int[] memo,boolean[] isVisited, int root,int[] ans){

        isVisited[root]=true;
        int sum =0;
        int childCount=0;
        for(int child : map.get(root)){
            if(isVisited[child])continue;
            dfs(map,memo,isVisited,child,ans);
            childCount+=memo[child]+1;
            sum+=ans[child]+memo[child]+1;
        }
        ans[root]=sum;
        memo[root]= childCount;
    }
}