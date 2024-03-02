class Solution {

    private int mod = 1000000007;

    public int[] productQueries(int n, int[][] q) {

        int[] powers = powerGenrator(n);
        //System.out.println(powers[0]);
        for(int i=1;i<powers.length;i++){
            powers[i]+=powers[i-1];
            //System.out.println(powers[i]);
        }
        int[] ans = new int[q.length];
        for(int i=0;i<q.length;i++){
            int start = q[i][0];
            int end = q[i][1];
            long cur=0l;
            if(start==0){
                ans[i]=(int)(Math.pow(2,powers[end])%mod);
            }else{
                int pow = powers[q[i][1]]-powers[q[i][0]-1];
                ans[i]=(int)(Math.pow(2,pow)%mod);
            }
        }
        return ans;
    }
    
    
    public int[] powerGenrator(int n){

        List<Integer> l = new ArrayList<>();
        int mul=0;
        while(n>0){
            if(n%2!=0) l.add(mul);
            n/=2;
            mul++;
        }
        int[] ans = new int[l.size()];
        for(int i=0;i<l.size();i++){
            ans[i]=l.get(i);
            //System.out.println(ans[i]);
        }
        return ans;
    }
}