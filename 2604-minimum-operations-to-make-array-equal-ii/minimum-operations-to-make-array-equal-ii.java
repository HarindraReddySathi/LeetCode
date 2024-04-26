class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        long pos =0;
        long neg =0;
        for(int i=0;i<n;i++){
            if(nums1[i]==nums2[i]) continue;
            if(k==0 || (nums1[i]-nums2[i])%k!=0) return -1;
            long steps = (1l*(nums1[i]-nums2[i]))/k;
            if(steps>0)pos+=steps;
            else neg+=steps;
        }
        if(pos+neg==0) return pos;
        return -1;
    }
}