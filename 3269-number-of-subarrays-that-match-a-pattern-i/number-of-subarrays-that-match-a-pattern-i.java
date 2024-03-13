class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int count = 0;
        for(int i=0;i<n-m;i++){
            boolean dec = true;
            for(int j=0;j<m;j++){
                if(pattern[j] == 1){
                    if(nums[i+j+1] <= nums[i+j]) {
                        dec = false;
                        break;
                    }
                } else if(pattern[j] == 0){
                    if(nums[i+j+1] != nums[i+j]) {
                        dec = false;
                        break;
                    }
                } else{
                    if(nums[i+j+1] >= nums[i+j]) {
                        dec = false;
                        break;
                    }
                }
            } 
            if(dec) {
                System.out.println(i);
                count++;
            }
        }
            return count;

    }
}