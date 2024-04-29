class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] aCount = new int[51];
        int[] bCount = new int[51];
        int common =0;
        for(int i=0;i<n;i++){
            aCount[A[i]]++;bCount[B[i]]++;
            if(A[i]==B[i]) common++;
            else{
                if(aCount[A[i]]==bCount[A[i]]) common++;
                if(aCount[B[i]]==bCount[B[i]]) common++;
            }
            A[i]=common;
        }
        return A;
    }
}