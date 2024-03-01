class Solution {
    /*public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] memo = new int[2*n];
        //int zc=0;
        for(int i=0;i<n;i++){
            int k = gas[i]-cost[i];
            memo[i]=k;
            memo[n+i]=k;
        }
        //System.out.println(zc+"---"+n);
        int i=0;
        int j=0;
        int sum=0;
        while(i<n){
            //System.out.println(i+"---"+j+"--"+sum);
            if(memo[i]<0){
                if(sum!=0)sum-=memo[i];
                i++;
                j=Math.max(i,j);
                continue;
            }
            sum+=memo[j];
            j++;
            while(sum<0){
                sum-=memo[i];
                i++;
            }
            if(sum>=0 && j-i==n) return i;
        }
        return -1;
    }*/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int sum = 0;
        for(int i=0;i<cost.length;i++){
            gas[i] -= cost[i];
            sum += gas[i];
        }
        if(sum<0)
            return -1;
        int total = 0;
        int startIndex = 0;
        for(int i=0;i<cost.length;i++){
            total += gas[i];
            if(total < 0){
                total = 0;
                startIndex = i + 1;
            }
        }
        return startIndex;
    }
}