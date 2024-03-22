class Solution {
    public int addDigits(int num) {
        while(num>9){
            num = digitSum(num);
        }
        return num;
    }

    public int digitSum(int n){
        int sum =0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}