class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] fuck = new int[1001];
        int[] you = new int[1001];
        for(int i : nums1){
            if(fuck[i]==0) fuck[i]++;
        }
        for(int i : nums2){
            if(fuck[i]==1)fuck[i]++;
        }
        int ans =0;
        for(int i=0;i<1001;i++){
            if(fuck[i]==2) ans++;
        }
        int[] res = new int[ans];
        int pos =0;
        for(int i=0;i<1001;i++){
            if(fuck[i]==2){
                res[pos]=i;
                pos++;
            }
        }
        return res;
    }
}