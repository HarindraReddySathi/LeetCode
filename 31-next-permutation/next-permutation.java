class Solution {
    public void nextPermutation(int[] nums) {
        
        int n =nums.length;
        int dip=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                dip=i;
                break;
            }
        }
        if(dip!=-1){
            for(int i=n-1;i>dip;i--){
                if(nums[i]>nums[dip]){
                    swap(nums,i,dip);
                    break;
                }
            }
        }
        reverse(nums,dip+1,n-1);
    }

    public void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;end--;
        }
    }

    public void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}