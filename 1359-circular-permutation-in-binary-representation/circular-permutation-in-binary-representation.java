class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        int end = 1<<n;
        for(int i=0;i<end;i++){
            ans.add(start^i^i>>1);
        }
        return ans;
    }
}