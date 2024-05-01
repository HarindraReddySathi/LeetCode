class Solution {
    public long minimumPerimeter(long neededApples) {
        
        int high = 1000000;
        int low = 1;
        long side =1;
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(cal(mid,neededApples)){
                side = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return 8l*side;
    }

    public boolean cal(int n,long neededApples){

        return 2l*n*(1l+n)*(2l*n+1)>=neededApples;
    }
}