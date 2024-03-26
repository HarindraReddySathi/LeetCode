class Solution {

    private static int mod = 1000000000+7;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        Map<Integer,Long> outspoken = new HashMap<>();
        Map<Integer,Long> forgot = new HashMap<>();
        long ans =1;
        int cur=1;
        long speaking = 0;
        outspoken.put(cur+delay,1l);
        forgot.put(cur+forget,1l);
        cur++;
        while(cur<=n){
            if(forgot.containsKey(cur)){
                speaking-=forgot.get(cur)%mod;
                ans -=forgot.get(cur);
            }
            if(outspoken.containsKey(cur)){
                speaking+=outspoken.get(cur)%mod;
            }
            if(speaking!=0){
                outspoken.put(cur+delay,speaking%mod);
                forgot.put(cur+forget,speaking%mod);
            }
            ans +=speaking%mod;
            cur++;
        }
        return (int)(ans%mod);
    }
}