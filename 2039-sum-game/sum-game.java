class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int[] sum = new int[2];
        int[] q = new int[2];
        char[] ch = num.toCharArray();
        int half = n/2;
        for(int i =0;i<n;i++){
            int pos = (i<half) ?0:1;
            if(ch[i]=='?')q[pos]++;
            else{
                sum[pos]+=ch[i]-'0';
            }
        }
        if((sum[0]>sum[1] && q[0]>q[1])||(sum[1]>sum[0] && q[1]>q[0])) return true;
        int diff = (sum[0]>sum[1]) ? sum[0]-sum[1] : sum[1]-sum[0];
        int vaca = (q[0]>q[1]) ? q[0]-q[1] : q[1]-q[0];
        if(vaca%2!=0 || diff%9!=0) return true;
        if(vaca/2==diff/9) return false;
        return true;
    }
}