class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        //List<Integer> list = new ArrayList<>();
        int[] list = new int[(n*(n+1)/2)];
        int pos =0;
        for(int i=0;i<n;i++){
            int sum =0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                list[pos++] = sum;
            }
        }
        Arrays.sort(list);
        long ans=0;
        for(int i= left-1;i<right;i++){
            //ans = (ans+list.get(i))%(1000000000+7);
            ans+=list[i];
        }
        return (int)(ans%(1000000000+7));
    }
}