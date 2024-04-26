class Solution {
    public int[] separateDigits(int[] nums) {
        int size=0;
        for(int i : nums){
            if(i<10)size++;
            else if(i<100) size+=2;
            else if(i<1000) size+=3;
            else if(i<10000)size+=4;
            else if(i<100000)size+=5;
            else size+=6;
        }
        int[] ans = new int[size--];
        for(int i=nums.length-1;i>=0;i--){
            int num = nums[i];
            while(num>0){
                ans[size--] = num%10;
                num /= 10;
            }
        }
        return ans;
    }
}