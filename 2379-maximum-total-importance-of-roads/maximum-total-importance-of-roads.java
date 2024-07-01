class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] incoming = new int[n];
        for(int[] road : roads){
            incoming[road[0]]++;
            incoming[road[1]]++;
        }
        Arrays.sort(incoming);
        long maxTotalImportance =0;
        int i = n-1;
        while(n>0){
            maxTotalImportance += 1l*incoming[i--]*n--;
        }
        return maxTotalImportance;
    }
}