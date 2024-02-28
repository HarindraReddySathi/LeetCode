class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k>=n)k=k%n;
        if(k==0) return;
        Stack<Integer> q = new Stack<>();
        int i=n-1;
        int count =k;
        while(count>0){
            q.push(nums[i]);
            i--;
            count--;
        }
        int j=n-1;
        while(i>=0){
            nums[j]=nums[i];
            i--;j--;
        }
        i=0;
        while(i<k){
            nums[i]=q.pop();
            i++;
        }

    }
}