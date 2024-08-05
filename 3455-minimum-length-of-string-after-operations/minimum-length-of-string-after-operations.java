class Solution {
    public int minimumLength(String s) {
        
        int[] alpha = new int[26];

        for(char c : s.toCharArray()){
            alpha[c-'a']++;
        }

        int min =0;

        for(int i : alpha){
            min += shortening(i);
        }
        return min;
    }

    public int shortening(int i){
        while(i>=3){
            int rem = i%3;
            i = i/3;
            i+=rem;
        }
        return i;
    }
}