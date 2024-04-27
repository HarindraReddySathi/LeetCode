class Solution {
    public List<Boolean> kidsWithCandies(int[] c, int ec) {
        
        int n = c.length;
        int max = 0;
        for(int i : c){
            if(i>max)max=i;
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i : c){
            if(i+ec>=max)ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}