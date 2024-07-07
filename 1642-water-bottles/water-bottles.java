class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int ans =0, empty =0;//,count=0;

        while(numBottles>0){// && count++<4){
            //System.out.println(numBottles);
            ans += numBottles;
            numBottles += empty;
            empty = numBottles%numExchange;
            numBottles /= numExchange;
            //System.out.println(numBottles);
        }

        return ans;
    }
}