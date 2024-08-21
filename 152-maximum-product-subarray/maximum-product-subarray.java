class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;

        // Initialize max and min products for the first element
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for(int i=1;i<n;i++){

            if(nums[i]<0){
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i],nums[i]*maxProduct);
            minProduct = Math.min(nums[i],nums[i]*minProduct);

            result = Math.max(maxProduct,result);
        }
        
        return result;
    }
}