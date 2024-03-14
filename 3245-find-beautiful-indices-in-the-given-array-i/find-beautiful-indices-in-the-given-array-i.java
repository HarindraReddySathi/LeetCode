class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> aind = new ArrayList<>();
        List<Integer> bind = new ArrayList<>();

        int aidx = 0;
        while(aidx != -1){
            int idx = s.indexOf(a, aidx);
            if(idx == -1) break;
            else {
                aind.add(idx);
                aidx=idx+1;
            }
        }

        int bidx = 0;
        while(bidx != -1){
            int idx = s.indexOf(b, bidx);
            if(idx == -1) break;
            else {
                bind.add(idx);
                bidx=idx+1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(Integer i : aind) {
            for(Integer j : bind){
                if(j>= i-k && j<=i+k) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}