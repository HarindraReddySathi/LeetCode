class Solution {
    public int countTriples(int n) {
        int ans=0;
        for(int i =1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                int k = i*i+j*j;
                int a = (int)Math.sqrt(k);
                if(a<=n && a*a==k){
                    ans++;
                    //System.out.println("( "+i+" , "+j+" , "+a+")");
                }
            }
        }
        return ans;
    }


}