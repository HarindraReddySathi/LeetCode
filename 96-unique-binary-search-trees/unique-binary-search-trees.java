class Solution {
    public int numTrees(int n) {
        int ans =0;
        for(int i =1;i<=n;i++){
            int left = uniqueBST(1,i-1);
            int right = uniqueBST(i+1,n);
            ans+=left*right;
        }
        return ans;
    }

    public int uniqueBST(int low , int high){
        
        if(low>high) return 1;
        if(low==high) return 1;
        int ans = 0;
        for(int i = low;i<=high;i++){
            ans += uniqueBST(low,i-1) * uniqueBST(i+1,high);
        }
        return ans;
    }
}