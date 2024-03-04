class Solution {
    public int candy(int[] r) {
        //return 0;
        int n = r.length;
        int[] prefix = new int[n];
        //Arrays.fill(prefix,-1);
        int cur=1;
        for(int i=0;i<n-1;i++){
            prefix[i]=cur;
            if(r[i]<r[i+1]){
                cur++;
            }else{
                cur=1;
            }
        }
        prefix[n-1]=cur;
        int[] sufix = new int[n];
        //Arrays.fill(sufix,-1);
        cur=1;
        for(int i=n-1;i>0;i--){
            sufix[i]=cur;
            if(r[i]<r[i-1]){
                cur++;
            }else{
                cur=1;
            }
        }
        sufix[0]=cur;
        int ans =0;
        for(int i=0;i<n;i++){
            ans+=Math.max(prefix[i],sufix[i]);
        }
        return ans;
    }
}