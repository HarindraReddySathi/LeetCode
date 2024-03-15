class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        long s1 = 0;
        long s2 = 0;
        int z1 = 0;
        int z2 = 0;
        for(int i : nums1){
            if(i==0)z1++;
            s1+=i;
        }
        for(int i : nums2){
            if(i==0)z2++;
            s2+=i;
        }
        if(s1+z1>s2+z2) return findMin(n2,s2,z2,n1,s1,z1);
        return findMin(n1,s1,z1,n2,s2,z2);
    }

    public long findMin(int n1,long s1,int z1,int n2,long s2,int z2){
        s2+=z2;
        long diff = s2-s1;
        if(diff<z1 || (diff>0 && z1==0))return -1l;
        return s2;
    }
}