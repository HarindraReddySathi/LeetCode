class Solution {
    public int[] diStringMatch(String s) {
        
        int n = s.length();
        int[] ans = new int[n+1];
        char[] ch = s.toCharArray();
        int low = 0;
        int high = n;
        if(ch[0] == 'D') {
            ans[0] = high;
            high--;
        }
        else low++;
        
        for(int i=1;i<n;i++) {
            if(ch[i] == 'D') {
                ans[i] = high;
                high--;
            }
            else if(ch[i] == 'I') {
                ans[i] = low;
                low++;
            }
            
        }
        ans[n] = low;
        return ans;

    }
}