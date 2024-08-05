class Solution {
    public String losingPlayer(int x, int y) {
        
        y = y/4;
        x = (x>=y) ? y : x;

        if(x%2==0) return "Bob";
        return "Alice";
    }
}