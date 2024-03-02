class Solution {
    public int maxProfit(int[] p) {
        
        int n = p.length;
        int ans=0;
        int dif =0;
        for(int i=0;i<n-1;i++){
            if(p[i]>p[i+1]){
                ans+=dif;
                dif=0;
            }else{
                dif+=p[i+1]-p[i];
            }
        }
        if(dif!=0)ans+=dif;
        return ans;
    }
}