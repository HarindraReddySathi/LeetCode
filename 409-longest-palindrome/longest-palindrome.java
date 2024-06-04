class Solution {
    public int longestPalindrome(String s) {
        
        int[][] alpha = new int[26][2];
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(c>='a' && c<='z'){
                alpha[c-'a'][0]++;
            }else{
                alpha[c-'A'][1]++;
            }
        }
        int ans = 0;
        boolean odd = true;
        for(int[] i : alpha){
            //System.out.println(i[0]+" -- "+i[1]);
            ans+=2*((i[0]/2)+(i[1]/2));
            if(odd && (i[0]%2!=0 || i[1]%2!=0)){
                ans++;
                odd = false;
            }
        }
        return ans;
    }
}