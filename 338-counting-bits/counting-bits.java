class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        for(int i=0;i<n+1;i++){
            ans[i]=countOnesiBinary(i);
        }
        return ans;
    }

    public int countOnesiBinary(int i){
        int mask =1;
        int count=0;
        for(int j = 1; j <=32; j++) {
            count+=((i & mask)==0)?0:1;
            mask<<=1;
        }
        return count;
    }
}