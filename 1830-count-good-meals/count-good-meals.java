class Solution {
    private static int mod = 1000000000+7;
    public int countPairs(int[] deliciousness) {
        int[] power = new int[22];
        power[0]=1;
        for(int i=1;i<22;i++)power[i]=(power[i-1]*2);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : deliciousness){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        long ans=0;
        for(int i : deliciousness){
            for(int j : power){
                if(j<i) continue;
                int k = Math.abs(j-i);
                if(k==i && map.get(k)==1) continue;
                if(k==i)ans+=map.get(k)-1;
                else if(map.containsKey(k))ans+=map.get(k);
            }
        }
        ans=ans/2;
        return (int)(ans%mod);
    }
}