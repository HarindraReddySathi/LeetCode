class Solution {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i : nums){
            if(i<0) max = Math.max(max,i);
            
            if(i>=0) min = Math.min(min,Math.abs(i));
        }
        if(max == Integer.MIN_VALUE) return min;
        return (Math.abs(max) >= min) ? min: max;
    }
}