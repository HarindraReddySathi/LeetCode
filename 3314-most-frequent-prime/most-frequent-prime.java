class Solution {
    private static Set<Integer> primes = seive();
    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans  = new int[2];
        ans[0]=-1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                formater(mat, i, j, 1, 0, map, primes,0,1,ans);// South
                formater(mat, i, j, 1, 1, map, primes,0,1,ans);// South-East
                formater(mat, i, j, 0, 1, map, primes,0,1,ans);// East
                formater(mat, i, j, -1, 1, map, primes,0,1,ans);// North-East
                formater(mat, i, j, -1, 0, map, primes,0,1,ans);// North
                formater(mat, i, j, -1, -1, map, primes,0,1,ans);// North-West
                formater(mat, i, j, 0, -1, map, primes,0,1,ans);// West
                formater(mat, i, j, 1, -1, map, primes,0,1,ans);// South-West
            }
        }
        return ans[0];
    }

    public void formater(int[][] mat, int i, int j, int x, int y, Map<Integer, Integer> map, Set<Integer> primes,int cur,int fac,int[] ans) {
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length) return;
        cur += mat[i][j]*fac;
        fac*=10;
        if(primes.contains(cur)){
            map.put(cur,map.getOrDefault(cur,0)+1);
            if(map.get(cur)>ans[1]){
                ans[0]=cur;
                ans[1]=map.get(cur);
            }else if(map.get(cur)==ans[1]){
                if(cur>ans[0])ans[0]=cur;
            }
        }
        formater(mat, i+x, j+y, x, y, map, primes,cur,fac,ans);
    }

    public static Set<Integer> seive(){
        Set<Integer> ans = new HashSet<>();
        int max = 999999+1;
        boolean[] seive = new boolean[max];
        for(int i=2 ;i<max;i++){
            if(i>10 && !seive[i]) ans.add(i);
            int j=2*i;
            while(j<max){
                seive[j]=true;
                j=j+i;
            }
        }
        return ans;
    }
}