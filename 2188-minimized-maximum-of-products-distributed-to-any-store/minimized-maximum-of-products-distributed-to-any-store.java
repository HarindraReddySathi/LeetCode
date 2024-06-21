class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int m =  quantities.length;

        //int low = Integer.MAX_VALUE;
        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            //if(quantities[i]<low) low = quantities[i];
            if(quantities[i]>high) high = quantities[i];
        }
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(isPossible(mid,quantities,n)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    public boolean isPossible(int mid,int[] quantities,int n){

        for(int i : quantities){
            n -= Math.ceil((double)i/mid);
        }
        return (n>=0);
    }
}