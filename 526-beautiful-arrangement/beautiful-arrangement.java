class Solution {
    public int countArrangement(int n) {
        Map<Integer,List<Integer>> multiples = new HashMap<>();
        Map<Integer,List<Integer>> factors = new HashMap<>();
        sieve(multiples,factors,n);
        int[] memo = new int[n+1];
        return DFS(multiples,factors,memo,1,n);  
    }

    public int DFS(Map<Integer,List<Integer>> multiples,Map<Integer,List<Integer>> factors,int[] memo,int level,int n){
        if(level==n+1) return 1;
        int ans = 0;
        if(memo[level]==0){
            memo[level]=1;
            ans=ans+DFS(multiples,factors,memo,level+1,n);
            memo[level]=0;
        }
        if(multiples.size()!=0 && multiples.containsKey(level)){
            for(Integer i : multiples.get(level)){
                if(memo[i]==0){
                    memo[i]=1;
                    ans=ans+DFS(multiples,factors,memo,level+1,n);
                    memo[i]=0;
                }
            }
        }
        if(factors.size()!=0 && factors.containsKey(level)){
            for(Integer i : factors.get(level)){
                if(memo[i]==0){
                    memo[i]=1;
                    ans=ans+DFS(multiples,factors,memo,level+1,n);
                    memo[i]=0;
                }
            }
        }
        return ans;
    }

    public void sieve(Map<Integer,List<Integer>> multiples,Map<Integer,List<Integer>> factors,int n){
        for(int i=1;i<=n;i++){
            int j = i+i;
            while(j<=n){
                System.out.println(i+"--"+j);
                multiples.computeIfAbsent(i,p-> new ArrayList<>()).add(j);
                factors.computeIfAbsent(j,p-> new ArrayList<>()).add(i);
                j+=i;
            }
        }
    }
}