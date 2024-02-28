class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); 
        for(int i=0;i<spells.length;i++){
            int low =0;
            int high = potions.length-1;
            while(low<=high){
                int mid = low+((high-low)>>1);
                long p =1l*spells[i]*potions[mid];
                if(p>=success)high=mid-1;
                else low = mid+1;
            }
            spells[i]=potions.length-1-high;
        }
        return spells;
    }
    /*class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int maxP = 0;
        for (int p : potions) maxP = Math.max(maxP, p);
        int[] suf = new int[maxP + 1];
        for (int p : potions) suf[p]++;
        for (int i = suf.length - 2; i >= 0; i--) suf[i] += suf[i + 1];
        for (int i = 0; i < spells.length; i++) {
            long v = (success + spells[i] - 1 ) / spells[i]; 
            spells[i] = v > maxP ? 0 : suf[(int)v];
        }
        return spells;
    }*/
}