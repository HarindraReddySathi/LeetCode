class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isUsed = new boolean[n];
        int[] temp = new int[n];
        permutations(ans,isUsed,temp,0,n,nums);
        return ans;
    }

    public void permutations(List<List<Integer>> ans,boolean[] isUsed,int[] temp,int level,int n,int[] nums){
        if(level==n){
            List<Integer> subAns = new ArrayList<>();
            for(int i:temp){
                subAns.add(nums[i]);
            }
            ans.add(subAns);
            return;
        }
        for(int i=0;i<n;i++){
            if(!isUsed[i]){
                temp[level]=i;
                isUsed[i]=true;
                permutations(ans,isUsed,temp,level+1,n,nums);
                isUsed[i]=false;
            }
        }
    }
}