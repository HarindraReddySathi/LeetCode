class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        if(cost1>total && cost2>total) return  1;
        if(cost1>total) return (total/cost2)+1;
        if(cost2>total) return (total/cost1)+1;
        if(cost1<cost2)waysToBuyPensPencils(total,cost2,cost1);
        int limit = total/cost2;
        long ans =(total/cost1)+1;
        for(int i =1;i<=limit;i++){
            total -= cost2;
            ans +=(total/cost1)+1;
        }
        return ans;
    }
}