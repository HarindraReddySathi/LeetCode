class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int m = rolls.length;
        int roolsSum =0;
        for(int i: rolls) roolsSum+=i;
        int remainingSum  = (mean*(m+n)) - roolsSum;

        if(remainingSum<n || remainingSum > 6*n) return new int[0];

        int[] ans = new int[n];
        Arrays.fill(ans,1);
        remainingSum -=n;
        int pos =0;
        while(remainingSum>0){
            if(remainingSum >5){
                ans[pos] += 5;
                remainingSum -=5;
            }else{
                ans[pos] += remainingSum;
                remainingSum =0;
            }
            pos++;
        }

        return ans;
    }
}