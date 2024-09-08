class Solution {
    public int maxPossibleScore(int[] start, int d) {
        
        int n = start.length;
        Arrays.sort(start);
        int low =0 ,high = start[n-1] - start[0]+d;
        //System.out.println(high);
        int ans = 0;

        while(low<=high){
            int mid = (int)((0l+low+high)/2);
            //System.out.println(low + " --- "+mid+" -- "+high);
            if(isPossible(start,d,mid)){
                //System.out.println("TRUE");
                ans = mid;
                low = mid+1;
            }else{
                //System.out.println("FALSE");
                high = mid-1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] start, int d, int min){

        int cur = start[0];
        int n = start.length;
        for(int i=1;i<n;i++){
            //System.out.println(cur+min);
            if(0l+cur+min >= start[i] && 0l+cur+min <= start[i]+d){
                cur = cur+min;
                continue;
            }else if(0l+cur+min < start[i]){
                cur = start[i];
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}