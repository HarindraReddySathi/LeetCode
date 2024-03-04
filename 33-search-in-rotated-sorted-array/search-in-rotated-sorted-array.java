class Solution {
    public int search(int[] nums, int target) {

        if(nums.length==1) return (nums[0]==target)?0:-1;
        int peakpos = peakFinder(nums);
        System.out.println(peakpos);
        if(peakpos==0)peakpos=nums.length;
        int pos= binarySearch(nums,0,peakpos-1,target);
        if(pos==-1)pos = binarySearch(nums,peakpos,nums.length-1,target);
        return pos;
    }

    public int peakFinder(int[] nums) {
        int l=0, r = nums.length -1 ; // l - left,  r - right
        int m; //mid
        while(l < r){
            m = l+(r-l)/2; //default mid
            if(nums[m] > nums[r]){ 
                l = m+1;
            }else{ 
                r = m;
            }
        }
        return l;
    }
    public int binarySearch(int[]nums,int low,int high,int target){
        if(high<low) return -1;
        int mid = low+(high-low)/2;
        if(nums[mid]==target)return mid;
        else if(nums[mid]<target) return binarySearch(nums,mid+1,high,target);
        else return binarySearch(nums,low,mid-1,target);
    }
}