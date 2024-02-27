class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        //ans.add(new ArrayList<>());
        boolean[] isSelected = new boolean[n];
        subSetFinder(ans,isSelected,0,n,nums);
        return ans;
    }

    public void subSetFinder(List<List<Integer>> ans,boolean[] isSelected,int level,int n,int[] nums){

        if(level==n){
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(isSelected[i]) sub.add(nums[i]);
            }
            ans.add(sub);
            return;
        }
        subSetFinder(ans,isSelected,level+1,n,nums);
        isSelected[level]=true;
        subSetFinder(ans,isSelected,level+1,n,nums);
        isSelected[level]=false;

    }
}