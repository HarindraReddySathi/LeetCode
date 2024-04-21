class Solution {
    public int distinctAverages(int[] nums) {
        
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        Set<Double> s = new HashSet<>();
        while(j>i){
            double avg = (1d*(nums[i++]+nums[j--]))/2;
            s.add(avg);
        }
        return s.size();
    }
}