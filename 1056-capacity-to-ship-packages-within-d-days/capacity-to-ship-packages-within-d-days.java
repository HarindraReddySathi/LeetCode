class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int total = 0;
        int max = Integer.MIN_VALUE;
        for(int i:weights){
            total+=i;
            if(i>max)max =i;
        }
        int low = max;
        int high = total;
        int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(weights,days,mid)){
                ans=mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] weights,int days,int capacity){
        int n = weights.length;
        int i=0;
        int cur=0;
        while(i<n && days>0){
            days--;
            while(i<n && cur+weights[i]<=capacity){
                cur+=weights[i];
                i++;
            }
            if(i>=n) return true;
            cur=0;
        }
        return false;
    }
}