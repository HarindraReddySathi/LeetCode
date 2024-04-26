class Solution {
    public int[] decrypt(int[] code, int k) {

       int n = code.length;
       int[] ans = new int[n];
       if(k==0){
            return ans;
       }else if(k>0){
            int sum =0;
            for(int i =0;i<=k;i++)sum+=code[i];
            int end = k;
            for(int i=0;i<n;i++){
                ans[i] = sum-code[i];
                sum-=code[i];
                end++;
                if(end==n)end=0;
                sum+=code[end];
            }
       }else{
            int sum =0;
            for(int i =n-1;i>=n+k-1;i--)sum+=code[i];
            int end = n+k-1;
            for(int i=n-1;i>=0;i--){
                ans[i] = sum-code[i];
                sum-=code[i];
                end--;
                if(end==-1)end=n-1;
                sum+=code[end];
            }
       }
       return ans;
    }
}