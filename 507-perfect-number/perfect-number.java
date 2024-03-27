class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1) return false;
        long sum =1;
        for(int i=2;i<num;i++){
            if(num%i==0)sum+=i;
            if(sum>num) return false;
        }
        if(sum<num) return false;
        return true;
    }
}