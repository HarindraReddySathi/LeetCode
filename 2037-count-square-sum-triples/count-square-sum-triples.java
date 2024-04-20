class Solution {
    public int countTriples(int n) {
        int ans=0;
        Map<Integer,Integer> numToSq = new HashMap<>();
        Map<Integer,Integer> sqToNum = new HashMap<>();
        for(int i =1;i<=n;i++){
            int sq = i*i;
            numToSq.put(i,sq);
            sqToNum.put(sq,i);
        }
        for(int i =1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                int sq = numToSq.get(i)+numToSq.get(j);
                if(sqToNum.containsKey(sq))ans++;
            }
        }
        return ans;
    }


}