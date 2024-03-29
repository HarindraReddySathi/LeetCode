class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Comparator<int[]> c = new Comparator<>(){
            public int compare(int[] i1,int[] i2){
                return Integer.compare(i1[1],i2[1])*-1;
            }
        };
        Arrays.sort(boxTypes,c);
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