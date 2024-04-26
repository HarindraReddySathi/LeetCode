class Solution {
    public int maximizeWin(int[] p, int k) {
        
        int n = p.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int i=0,j=0,max =-1;
        int ans =0;
        while(j<n){

            while(j<n && p[j]-p[i]<=k){
                if(max<j-i+1)max = j-i+1;
                prefix[j]=max;
                if(ans<j-i+1) ans = max;
                j++;
            }
            i++;
        }

        i=n-1;j=n-1;max =-1;
        while(j>=0){

            while(j>=0 && p[i]-p[j]<=k){
                if(max<i-j+1)max = i-j+1;
                suffix[j]=max;
                if(ans<i-j+1) ans = max;
                j--;
            }
            i--;
        }
        i=0;
        while(i<n-1){
            if(p[i]!=p[i+1]){
                int cur = prefix[i]+suffix[i+1];
                if(cur>ans) ans =cur;
            }
            i++;
        }

        return ans;

    }
}