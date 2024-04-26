class Solution {
    public boolean digitCount(String num) {
        
        int[] check = new int[10];
        char[] ch = num.toCharArray();
        int n = ch.length;
        for(char c : ch){
            check[c-'0']++;
        }
        for(int i =0;i<n;i++){
            if(ch[i]-'0' != check[i]) return false;
        }
        return true;
    }
}