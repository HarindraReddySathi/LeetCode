class Solution {
    public long countCompleteDayPairs(int[] hours) {
        
        int[] count = new int[24];
        for(int i : hours){
            count[i%24]++;
        }
        long pairCount = 0;
        for(int i=1;i<12;i++){
            pairCount += 1l*count[i]*count[24-i];
        }

        pairCount += (1l*(count[0])*(count[0]-1))/2;
        pairCount += (1l*(count[12])*(count[12]-1))/2;

        return pairCount;
    }
}