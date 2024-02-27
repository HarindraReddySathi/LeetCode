class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        int n1 = s.length();
        int n2 = t.length();
        //if(n1!=n2) return false;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(int i=0;i<n1;i++){
            if(ch1[i]!='#')s1.push(ch1[i]);
            else if(!s1.isEmpty())s1.pop();
        }
        for(int i=0;i<n2;i++){
            if(ch2[i]!='#')s2.push(ch2[i]);
            else if(!s2.isEmpty())s2.pop();
        }
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.pop()!=s2.pop()) return false;
        }
        if(s1.isEmpty() && s2.isEmpty()) return true;
        return false;
    }
}