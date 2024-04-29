class Solution {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        int n = num.length();
        char[] ch = num.toCharArray();
        for(char c : ch)count[c-'0']++;
        StringBuilder sb = new StringBuilder();
        int odd = -1;
        for(int i =9;i>=0;i--){
            if(sb.length()==0 && i==0){
                if(odd==-1) return "0";
                continue;
            }
            if(count[i]%2!=0 && odd==-1){
                odd =i;
            }
            while(count[i]>1){
                sb.append(i+"");
                count[i]-=2;
            }
        }
        String ans = sb.toString();
        if(odd!=-1) ans = ans+odd;
        ans = ans+ sb.reverse().toString();
        return ans;
    }
}