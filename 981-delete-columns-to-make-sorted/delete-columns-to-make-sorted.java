class Solution {
    public int minDeletionSize(String[] strs) {
        
        int m = strs.length;
        int n = strs[0].length();
        int ans =0;
        for(int j=0;j<n;j++){
            boolean isRemoved = false;
            for(int i =1;i<m;i++){
                if(strs[i].charAt(j)-strs[i-1].charAt(j)<0){
                    isRemoved=true;
                    break;
                }
            }
            if(isRemoved) ans++;
        }
        return ans;
    }
}