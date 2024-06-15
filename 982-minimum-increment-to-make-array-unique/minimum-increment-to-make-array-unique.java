class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        Arrays.sort(nums);
        Set<Integer> unique = new HashSet<>();
        int count=0;
        for(int i=1;i<nums.length;i++){
            
            // Ensure each element is greater than its previous
            if (nums[i] <= nums[i - 1]) {
                // Add the required increment to minIncrements
                int increment = nums[i - 1] + 1 - nums[i];
                count += increment;

                // Set the element to be greater than its previous
                nums[i] = nums[i - 1] + 1;
            }

        }
        return count;
    }
}