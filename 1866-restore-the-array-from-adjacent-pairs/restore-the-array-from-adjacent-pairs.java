class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        
        int  n = adjacentPairs.length;
        Map<Integer,List<Integer>> attach = new HashMap<>();
        for(int[] i : adjacentPairs){
            attach.computeIfAbsent(i[0],l -> new ArrayList<>()).add(i[1]);
            attach.computeIfAbsent(i[1],l -> new ArrayList<>()).add(i[0]);
        }
        int[] ans = new int[n+1];
        for(int i : attach.keySet()) {
            if(attach.get(i).size()==1){
                ans[0]=i;
                ans[1]=attach.get(i).get(0);
                break;
            }
        }
        for(int i =2;i<=n;i++){
            List<Integer> l = attach.get(ans[i-1]);
            for(int j : l){
                if(j!=ans[i-2]){
                    ans[i]=j;
                    break;
                }
            }
        }
        return ans;
    }
}