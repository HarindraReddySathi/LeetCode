class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) -> b[1]-a[1]);
        int ans=0;
        for(int[] i : boxTypes){
            int count = Math.min(i[0],truckSize);
            ans+=(count*i[1]);
            truckSize-=count;
            if(truckSize==0) break;
        }
        return ans;
    }
}