class Solution {
    public String reverseParentheses(String str) {
        
        int n = str.length();
        char[] ch = str.toCharArray();
        Stack<String> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(ch[i]=='('){
                if(sb.length()!=0)s.push(sb.toString());
                if(sb.length()!=0) System.out.println(sb.toString());
                s.push("(");
                sb = new StringBuilder();
            }else if(ch[i]!=')') sb.append(ch[i]);
            else{
                s.pop();
                String temp=sb.reverse().toString();
                while(!s.isEmpty() && !s.peek().equals("(")){
                    temp=s.pop()+temp;
                }
                System.out.println(temp);
                sb = new StringBuilder(temp);
                //s.push(temp);
            }
        }
        return sb.toString();
    }
}