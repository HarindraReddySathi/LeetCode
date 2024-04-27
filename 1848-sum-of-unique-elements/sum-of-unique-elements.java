class Solution {
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        for(int i : nums){
            arr[i]++;
        }
        int sum =0;
        for(int i=0;i<=100;i++){
            if(arr[i]==1) sum+=i;
        }
        return sum;
    }
}