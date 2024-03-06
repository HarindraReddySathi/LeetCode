class Solution {
    public int longestMountain(int[] arr) {
        
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int count =0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                count++;
                prefix[i]=count;
            }else{
                count=0;
            }
        }
        count=0;
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                count++;
                suffix[i]=count;
            }else{
                count=0;
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(prefix[i]!=0 && suffix[i]!=0) ans = Math.max(ans,prefix[i]+suffix[i]+1);
        }
        return ans;
    }
}