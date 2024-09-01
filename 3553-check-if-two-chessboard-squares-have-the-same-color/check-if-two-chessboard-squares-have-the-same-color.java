class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        
        char[] ch1 = coordinate1.toCharArray();
        char[] ch2 = coordinate2.toCharArray();

        if((ch1[0]+ch1[1])%2==(ch2[0]+ch2[1])%2) return true;
        return false;

    }
}