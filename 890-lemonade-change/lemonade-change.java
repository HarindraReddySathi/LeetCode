class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int[] prev = new int[3];
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                prev[0]++;
            }else if(bills[i]==10){
                if(prev[0]<=0) return false;
                prev[0]--;
                prev[1]++;
            }else{
                if(prev[0]<=0) return false;
                if(prev[1]<=0 && prev[0]<3) return false;
                if(prev[1]>0){
                    prev[1]--;
                    prev[0]--;
                }else{
                    prev[0]-=3;
                }
            }
        }
        return true;
    }
}