class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(!stack.isEmpty() && (stack.peek()-'a'==c-'A' ||stack.peek()-'A'==c-'a' )){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}