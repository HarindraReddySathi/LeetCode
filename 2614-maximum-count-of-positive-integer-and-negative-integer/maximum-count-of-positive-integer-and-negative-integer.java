class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int l = leftBound(nums);
        int r = rightBound(nums);
        //System.out.println(l+"--"+r);
        if(l==-1 && r==-1) return 0;
        if(l==-1 && r!=-1) return r+1;
        if(l!=-1 && r==-1) return n-l;
        return Math.max(n-l,r+1);
    }

    public int leftBound(int[] nums){
        int n = nums.length;
        int low=0;
        int high=n-1;
        int ans =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>0){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int rightBound(int[] nums){
        int n = nums.length;
        int low=0;
        int high=n-1;
        int ans =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<0){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}