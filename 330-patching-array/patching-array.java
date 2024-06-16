class Solution {
    public int minPatches(int[] nums, int n) {

        int size = nums.length;
        int patches = 0;
        int ans = 0,pos =0;
        while(ans<n && ans>=0){
            if(pos<size && nums[pos]<=ans+1){
                ans+=nums[pos];
                pos++;
            }else{
                patches++;
                ans += (ans+1);
                //System.out.println(patches+ " -- "+ ans + " -- "+(ans>=n));
            }
        }
        return patches;
    }
}