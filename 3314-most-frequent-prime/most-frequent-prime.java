class Solution {
    private static Set<Integer> primes = seive();
    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] count  = new int[1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                formater(mat, i, j, 1, 0, map, primes,0,1,count);// South
                formater(mat, i, j, 1, 1, map, primes,0,1,count);// South-East
                formater(mat, i, j, 0, 1, map, primes,0,1,count);// East
                formater(mat, i, j, -1, 1, map, primes,0,1,count);// North-East
                formater(mat, i, j, -1, 0, map, primes,0,1,count);// North
                formater(mat, i, j, -1, -1, map, primes,0,1,count);// North-West
                formater(mat, i, j, 0, -1, map, primes,0,1,count);// West
                formater(mat, i, j, 1, -1, map, primes,0,1,count);// South-West
            }
        }
        int ans = -1;
        int max = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i) > max) {
                ans = i;
                max = map.get(i);
            } else if (map.get(i) == max) {
                if (i > ans)
                    ans = i;
            }
        }
        return ans;
    }

    public void formater(int[][] mat, int i, int j, int x, int y, Map<Integer, Integer> map, Set<Integer> primes,int cur,int fac,int[] count) {
        //System.out.println(count[0]);
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length) return;
        //count[0]++;
        cur += mat[i][j]*fac;
        fac*=10;
        if(primes.contains(cur)){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        formater(mat, i+x, j+y, x, y, map, primes,cur,fac,count);
        //count[0]--;
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