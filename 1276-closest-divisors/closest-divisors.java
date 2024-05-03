class Solution {
    public int[] closestDivisors(int num) {
        
        int n = (int)Math.sqrt(num+1);
        num++;
        if(num==n*n) return new int[]{n,n};
        int[] ans = new int[2];
        int res = num;
        for(int i = n;i>=1;i--){
            if(num%i == 0) {
                int temp = num/i;
                if(Math.abs(temp-i) < res) {
                    ans[0] = temp;
                    ans[1] = i;
                    res = Math.abs(temp-i);
                }
            } 
        }
        n = (int)Math.sqrt(num+2);
        num++;
        if(num==n*n) return new int[]{n,n};
        //res = num+1;
        for(int i = n;i>=1;i--){
            if(num%i == 0) {
                int temp = num/i;
                if(Math.abs(temp-i) < res) {
                    ans[0] = temp;
                    ans[1] = i;
                    res = Math.abs(temp-i);
                }
            } 
        }
        return ans;
    }
}