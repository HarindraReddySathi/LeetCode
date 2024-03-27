class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1) return false;
        int end = (int)Math.sqrt(num);
        long sum =1;
        for(int i=2;i<=end;i++){
            if(num%i==0){
                sum+=i;
                if(i*i!=num){
                    sum+=num/i;
                }
            }
            if(sum>num) return false;
        }
        if(sum<num) return false;
        return true;
    }
}