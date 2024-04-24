class Solution {
    public int subsetXORSum(int[] nums) {
        
        int n = nums.length;
        int stage =0;
        int cur=1;
        int ans =0;
        while(stage<5){
            int[] digit = new int[2]; 
            for(int i=0;i<n;i++){
                digit[nums[i]&1]++;
                nums[i] = nums[i]>>1;
            }
            int zero = (int)Math.pow(2,digit[0]);
            int one =0;
            int up = digit[1];
            int down = 1;
            int numer = digit[1];
            for(int j=1;j<=digit[1];j=j+2){
                one+=(numer);
                numer = (numer*(up-1)*(up-2))/((down+1)*(down+2));
                up-=2;
                down+=2;
            }
            ans+=(one*zero*cur);
            stage++;
            cur*=2;
        }
        return ans;
    }
}