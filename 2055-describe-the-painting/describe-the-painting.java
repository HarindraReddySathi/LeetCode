class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        int n = segments.length;
        List<List<Long>> ans = new ArrayList<>();
        long[] memo = new long[100001];
        boolean[] changestart = new boolean[100001];
        boolean[] changeend = new boolean[100001];
        for(int[] i : segments){
            memo[i[0]]+=i[2];
            changestart[i[0]]=true;
            memo[i[1]]-=i[2];
            changeend[i[1]]=true;
        }
        //for(int i =0;i<16;i++)System.out.println(memo[i]);
        List<Long> l = new ArrayList<>();
        for(int i =1;i<100001;i++){
            if(changestart[i] && changeend[i]){
                l.add((long)i);
                l.add(memo[i-1]);
                ans.add(l);
                l = new ArrayList<>();
                l.add((long)i);
            }
            else if(changestart[i]){
                if(l.size()!=0){
                    l.add((long)i);
                    l.add(memo[i-1]);
                    ans.add(l);
                    l = new ArrayList<>();
                }
                l.add((long)i);
            }
            else if(changeend[i]){
                l.add((long)i);
                l.add(memo[i-1]);
                ans.add(l);
                l = new ArrayList<>();
                if(memo[i] +memo[i-1]!=0)l.add((long)i);
            }
            memo[i] += memo[i-1];
        }
        return ans;
    }
}