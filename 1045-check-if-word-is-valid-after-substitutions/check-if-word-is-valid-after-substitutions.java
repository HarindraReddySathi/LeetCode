class Solution {
    public boolean isValid(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(ch[i]!='c'){
                stack.push(ch[i]);
                continue;
            }else{
                if(stack.isEmpty() || stack.pop()!='b' || stack.isEmpty() || stack.pop()!='a') return false;
            }
        }
        return stack.isEmpty();
    }
}