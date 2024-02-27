class Solution {
    public boolean judgeCircle(String moves) {
        int[] charCount = new int[26];
        for (char c : moves.toCharArray())
            charCount[c - 'A']++;
        
        return charCount['U' - 'A'] == charCount['D' - 'A'] && charCount['L' - 'A'] == charCount['R' - 'A'];
    }
}