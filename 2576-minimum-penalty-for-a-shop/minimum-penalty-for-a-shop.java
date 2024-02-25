class Solution {
    public int bestClosingTime(String customers) {
        char[] ch = customers.toCharArray();
        int n = ch.length;
        int[] pre = new int[n+1];
        int[] post = new int[n+1];
        pre[0]=0;
        //System.out.println(pre[0]);
        for(int i=1;i<n+1;i++){
            int dec = (ch[i-1]=='N')?1:0;
            pre[i]=pre[i-1]+dec;
            //System.out.println(pre[i]);
        }
        post[n] =0;
        //System.out.println(post[n]);
        for(int i=n-1;i>=0;i--){
            int dec = (ch[i]=='Y')?1:0;
            post[i]=post[i+1]+dec;
            //System.out.println(post[i]);
        }
        int min = Integer.MAX_VALUE;
        int position=-1;
        for(int i=0;i<=n;i++){
            int k = pre[i]+post[i];
            //System.out.println(k);
            if(k<min){
                min=k;
                position=i;
            }
        }
        return position;
    }
}