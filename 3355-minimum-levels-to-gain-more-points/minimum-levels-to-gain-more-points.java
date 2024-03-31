class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] prefix = new int[n];
        for(int i=0;i<n;i++){
            prefix[i]+=(possible[i]==0)?-1:1;
            if(i!=0)prefix[i]+=prefix[i-1];
            //System.out.println(prefix[i]);
        }
        for(int i=0;i<n-1;i++){
            if(prefix[i]>(prefix[n-1]-prefix[i])) return i+1;
        }
        return -1;
    }
}