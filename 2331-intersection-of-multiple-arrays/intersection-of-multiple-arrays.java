class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] check = new int[1001];
        int n = nums.length;
       // int m = nums[0].length;
        for(int i =0;i<n;i++){
            for(int j=0;j<nums[i].length;j++){
                check[nums[i][j]]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=1000;i++){
            if(check[i]==n)ans.add(i);
        }
        return ans;
    }
}