class Solution {
    public String removeDuplicates(String str) {
        
        char[] ch = str.toCharArray();
        int n = ch.length;
        if(n==1) return str;
        Stack<Character> s = new Stack<>();
        s.push(ch[0]);
        for(int i=1;i<n;i++){
            if(!s.isEmpty() && s.peek()==ch[i])s.pop();
            else s.push(ch[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}