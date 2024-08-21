class Solution {
    public int candy(int[] ratings) {
        
        int n = ratings.length;

        int[] l2R = new int[n];
        l2R[0] = 1;
        int[] r2L = new int[n];
        r2L[n-1] = 1;

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                l2R[i] = l2R[i-1]+1;
            }else{
                l2R[i] = 1;
            }
        }

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                r2L[i] = r2L[i+1]+1;
            }else{
                r2L[i] = 1;
            }
        }

        int totalCandiesRequired =0;

        for(int i=0;i<n;i++){
            totalCandiesRequired += Math.max(r2L[i],l2R[i]);
        }

        return totalCandiesRequired;
    }
}