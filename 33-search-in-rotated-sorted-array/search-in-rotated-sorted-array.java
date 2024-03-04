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
    public int decisionMaker(int[] nums, int mid){
        if(mid==0){
            if(nums[mid]>nums[mid+1]) return 0;
            return 1;
        }else if(mid == nums.length-1){
            if(nums[mid]>nums[mid-1]) return 0;
            return 2;
        }else{
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return 0;
            else if(nums[mid]>nums[nums.length-1] && nums[mid]>nums[0]) return 1;
            else return 2;
        }
    }

    public int binarySearch(int[]nums,int low,int high,int target){
        if(high<low) return -1;
        int mid = low+(high-low)/2;
        if(nums[mid]==target)return mid;
        else if(nums[mid]<target) return binarySearch(nums,mid+1,high,target);
        else return binarySearch(nums,low,mid-1,target);
    }
}