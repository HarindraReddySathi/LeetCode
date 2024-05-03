class Solution {
    public boolean[] canEat(int[] cc, int[][] queries) {

        int n = cc.length;
        int p = queries.length;
        boolean[] ans = new boolean[p];
        long[] candiesCount = new long[n];
        candiesCount[0]=(long)cc[0];
        for(int i=1;i<n;i++){
            candiesCount[i]=candiesCount[i-1]+cc[i];
        }
        int c =0;
        for(int[] i :queries){
            //System.out.println(candiesCount[i[0]] +" -- "+i[1]);
            if(candiesCount[i[0]]>i[1] && (i[0]==0 || candiesCount[i[0]-1]/i[2]<=i[1]))ans[c]=true;
            else ans[c]=false;
            c++;
        }
        return ans;
    }
}