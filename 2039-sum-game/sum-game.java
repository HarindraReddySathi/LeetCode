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
        int diff = sum[0]-sum[1];
        int vaca = q[0]-q[1];
        if(diff*vaca>0 || vaca%2!=0 || diff%9!=0) return true;
        if(vaca/2==(-1*diff/9)) return false;
        return true;
    }
}