class Solution {
    public int countTexts(String pressedKeys) {
        long ans =1l;
        int modulo = 1000000007;
        int[] map = {0,0,3,3,3,3,3,4,3,4};
        char[] ch = pressedKeys.toCharArray();
        int n =ch.length;
        int i=0,j=1;
        while(j<=n-1){
            while(j<n && ch[j]==ch[j-1]){
                j++;
            }
            ans=(ans*numWays(j-i,map[Integer.parseInt(String.valueOf(ch[i]))]))%modulo;
            i=j;
            j++;
        } 
        return (int)ans%modulo;
    }

    public long numWays(int n,int k){
        int modulo = 1000000007;
        long[] memo = new long[n];
        for(int i=0;i<Math.min(n,k);i++){
            memo[i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<=k;j++){
                if(i+j<n)memo[i+j]=(memo[i+j]+memo[i])%modulo;
            }
        }
        return memo[n-1];
    }

}