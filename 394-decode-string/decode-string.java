class Solution {
    public String decodeString(String s) {
        
        //StringBuffer ans = new StringBuffer();
        int n = s.length();
        char[] ch =s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(ch[i]!=']'){
                st.push(ch[i]);
            }else{
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peek()!='['){
                    sb.append(st.pop());
                }
                st.pop();
                StringBuilder counter = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    counter.append(st.pop());
                }
                int count = Integer.parseInt(counter.reverse().toString());
                String k =sb.reverse().toString();
                for(int x=1;x<=count;x++){
                    for(int p=0;p<k.length();p++) st.push(k.charAt(p));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        sb.reverse();
        return sb.toString();
    }
}