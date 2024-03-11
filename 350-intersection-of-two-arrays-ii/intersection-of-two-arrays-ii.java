class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] fuck = new int[1001];
        int[] you = new int[1001];
        for(int i : nums1) fuck[i]++;
        for(int i : nums2) you[i]++;
        int ans =0;
        for(int i=0;i<1001;i++){
            fuck[i]=Math.min(fuck[i],you[i]);
            ans+=fuck[i];
        }
        int[] res = new int[ans];
        int pos =0;
        for(int i=0;i<1001;i++){
            if(fuck[i]!=0){
                for(int j=0;j<fuck[i];j++){
                    res[pos]=i;
                    pos++;
                }
            }
        }
        return res;
    }
}