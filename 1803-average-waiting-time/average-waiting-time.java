class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double ans =0;
        long curTime =0; 
        for(int[] i : customers){
            ans += i[1];
            if(curTime > i[0]){
                ans += (curTime - i[0]);
                curTime += i[1];
            }else{
                curTime = i[0]+i[1];
            }
        }

        return ans/customers.length;
    }
}