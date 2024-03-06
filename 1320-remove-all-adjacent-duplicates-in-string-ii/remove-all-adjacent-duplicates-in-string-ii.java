class Solution {
    public String removeDuplicates(String str, int k) {
        
        int n = str.length();
        char[] ch = str.toCharArray();
        Stack<Pair> s = new Stack<>();
        for(int i=0;i<n;i++){

            if(s.isEmpty()){
                s.push(new Pair(ch[i]));
            }else{
                if(s.peek().c==ch[i] && s.peek().count==k-1){
                    s.pop();
                }else if(s.peek().c==ch[i] && s.peek().count!=k-1){
                    s.peek().count++;
                }else{
                    s.push(new Pair(ch[i]));
                }
            }
        }
        if(s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            Pair p = s.pop();
            for(int i=0;i<p.count;i++){
                sb.append(p.c);
            }
        }
        sb.reverse();
        return  sb.toString();

    }

    class Pair{
        char c;
        int count=1;

        public Pair(char c){
            this.c=c;
        }
    }
}