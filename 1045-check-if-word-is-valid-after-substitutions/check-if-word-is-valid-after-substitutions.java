class Solution {
    public boolean isValid(String s) {
        // while (s.contains("abc"))
        //     s = s.replaceAll("abc", "");
        // return s.isEmpty();

        char[] stack = new char[s.length()];
        int stackPtr = -1;
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                if (stackPtr > 0 && stack[stackPtr] == 'b' && stack[stackPtr-1] == 'a')
                    stackPtr = stackPtr - 2;
                else return false;
            } else stack[++stackPtr] = c;
        } return stackPtr == -1;
    }
}