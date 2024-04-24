class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        int end = (int)Math.pow(2,n)-1;
        for(int i=0;i<=end;i++){
            ans.add((i^(i>>1))^start);
        }
        return ans;
    }
}