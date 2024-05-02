class Solution {
    public int findMaxK(int[] nums) {
        
        int[] posCheck = new int[1001];
        int[] negCheck = new int[1001];
        for(int i : nums){
            if(i>0)posCheck[i]++;
            if(i<0)negCheck[i*-1]++;
        }
        for(int i =1000;i>=0;i--){
            if(posCheck[i]>0 && negCheck[i]>0) return i;
        }
        return -1;
    }
}