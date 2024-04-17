class Solution {
    public int countOdds(int low, int high) {
        if(low ==0 && high ==0) return 0;
        if(low%2==0) low++;
        if(high%2==0) high--;
        return high/2-low/2+1;
    }
}