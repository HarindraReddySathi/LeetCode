class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        
        int[] freq = new int[101];
        for(int i : nums1)freq[i]++;
        int[] ans = new int[2];
        for(int i : nums2){
            if(freq[i]!=0)ans[1]++;
            if(freq[i]>0){
                ans[0]+=freq[i];
                freq[i]*=-1;
            }
        }
        return ans;
    }
}