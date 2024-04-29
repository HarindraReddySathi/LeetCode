class Solution {
    public int minNumberOfHours(int ien, int iex, int[] en, int[] ex) {
        
        int n = en.length;
        int ans =0;
        int sum =0;
        for(int i =0;i<n;i++){
            sum+=en[i];
            if(ex[i]>=iex){
                int dif = ex[i]-iex+1;
                ans+=dif;
                iex+=dif;
            }
            iex+=ex[i];
        }
        if(sum>=ien) ans += sum+1-ien;
        return ans;
    }
}