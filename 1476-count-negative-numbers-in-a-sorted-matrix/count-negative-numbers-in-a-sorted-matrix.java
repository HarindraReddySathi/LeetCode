class Solution {
    public int countNegatives(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int ans =0;
        int temp = -1;
        int low = 0;
        int high = n-1;
        int prev = n-1;
        for(int i=0;i<m;i++){
            int mid = low+((high-low)>>1);
            while(low<=high){
                mid = low+((high-low)>>1);
                if(grid[i][mid]<0){
                    temp = mid;
                    high = mid-1;
                }else{
                    low=mid+1;
                }
            }
            temp = (temp==-1) ? prev+1 : temp;
            ans+=temp;
            if(temp==0) break;
            high =(temp==-1) ? prev : temp-1;
            prev = high;
            low =0;
            //System.out.println(low +" -- "+" -- "+high+" -- "+temp);
        }
        return m*n-ans;
    }
}