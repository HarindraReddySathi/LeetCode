class Solution {
    public String removeDuplicates(String str, int k) {
        
        int n = str.length();
        if(n<=2) return str;
        char[] ch = str.toCharArray();

        Stack<Pair> s = new Stack<>();
        s.add(new Pair(ch[0]));

        for(int i=1;i<n;i++){
            if(!s.isEmpty() && s.peek().c==ch[i]){
                Pair p = s.pop();
                if(p.count==k-1) continue;
                p.count++;
                s.push(p);
            }else{
                s.add(new Pair(ch[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            Pair p = s.pop();
            for(int i=0;i<p.count;i++){
                sb.append(p.c);
            }
        }
        sb.reverse();
        return sb.toString();
    }

    class Pair{
        char c;
        int count;

        public Pair(char c,int count){
            this.c=c;
            this.count=count;
        }

        public Pair(char c){
            this.c=c;
            this.count=1;
        }
    }
}