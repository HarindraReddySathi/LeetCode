class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==key){
                prefix[i]=i;
            }else{
                int dec = (i==0)?-1:prefix[i-1];
                prefix[i]=dec;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]==key){
                suffix[i]=i;
            }else{
                int dec = (i==n-1)?-1:suffix[i+1];
                suffix[i]=dec;
            }
        }
        for(int i=0;i<n;i++){
            if(prefix[i]!=-1 && i-prefix[i]<=k) ans.add(i);
            else if(suffix[i]!=-1 && suffix[i]-i<=k) ans.add(i);
        }
        return ans;
    }
}