class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int n = position.length;
        int low =1;
        int high = position[n-1] -position[0];
        int maxDistance = 1 ;
        while(high>=low){

            int mid = low + (high-low)/2;
            if(isPossible(mid,position,m)){
                maxDistance = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }

        }

        return maxDistance;
    }

    public boolean isPossible(int mid, int[] position, int m){

        int count =1;
        int start =position[0];
        int n = position.length;
        for(int i =1;i<n;i++){
            if(position[i]-start<mid) continue;
            start = position[i];
            count++;
        }
        return (count>=m);
    }
}