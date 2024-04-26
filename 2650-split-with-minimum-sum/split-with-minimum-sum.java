class Solution {
    public int splitNum(int n) {
        List<Integer> no = new ArrayList<>();

        while(n>0) {
            no.add(n%10);
            n/=10;
        }

        Collections.sort(no);

        int[] num = new int[2];
        int cur =0;
        for(int p:no) {
            num[cur]*=10;
            num[cur]+=p;
            cur = (cur==0)?1:0;
        }
        return num[0]+num[1];
    }
}