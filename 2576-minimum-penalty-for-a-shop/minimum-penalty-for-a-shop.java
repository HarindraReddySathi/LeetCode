class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        char[] ch = customers.toCharArray();

        int res = -1;
        int suffix = 0;
        for(int i=n-1;i>=0;i--){
            if(ch[i] == 'Y') suffix++;
        }
        int prefix = 0;
        int max = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++) {
            if(suffix + prefix < max) {
                max = suffix+prefix;
                res = i;
            }
            if(ch[i] == 'Y') suffix--;
            else prefix++;
        }
        if(prefix < max) return n;
        return res;
    }
}