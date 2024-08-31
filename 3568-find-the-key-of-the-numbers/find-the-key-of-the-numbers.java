class Solution {
    public int generateKey(int num1, int num2, int num3) {
        
        int key =0;
        int cur =1;

        while(num1!=0 && num2!=0 && num3!=0){

            key += cur*(Math.min(num1%10 ,Math.min(num2%10 , num3%10)));
            num1 /=10;
            num2 /=10;
            num3 /=10;
            cur *=10;
        }
        return key;
    }
}