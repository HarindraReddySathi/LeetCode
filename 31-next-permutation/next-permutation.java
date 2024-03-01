class Solution {

    public void nextPermutation(int[] nums) {
        int n= nums.length;
        if(n==1) return;
        if(n==2){
            swap(nums,0,1);
            return;
        }
        //Finding the first decreasing element
        int first =-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                 first =i;
                 break;
            }
        }

        if(first!=-1){
            for(int i=n-1;i>first;i--){
                if(nums[i]>nums[first]){
                    swap(nums,i,first);
                    break;
                }
            }
        }
        reverse(nums,first+1);
    }

    public void reverse(int[] nums,int i){
        int n = nums.length;
        for(int j=0;j<(n-i+1)/2;j++){
            int temp = nums[i+j];
            nums[i+j]=nums[n-j-1];
            nums[n-j-1]=temp;
        }
    }

    public void swap(int[] nums,int i,int j){
        System.out.println(i+"--"+j);
        int t= nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
}