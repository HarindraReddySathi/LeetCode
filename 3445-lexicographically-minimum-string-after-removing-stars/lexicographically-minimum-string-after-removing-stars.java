class Solution {
    public String clearStars(String s) {
        
        Stack<Integer>[] alphaStack = new Stack[26];
        for (int i = 0; i < 26; i++) {
            alphaStack[i] = new Stack<Integer>();
        }
        Set<Integer> forbidden = new HashSet<>();
        char[] ch = s.toCharArray();
        int n = ch.length;

        for(int i =0;i<n;i++){
            if(ch[i]=='*'){
                for (int j = 0; j < 26; j++) {
                    if(alphaStack[j].isEmpty()) continue;
                    forbidden.add(alphaStack[j].pop());
                    break;
                }
            }else{
                alphaStack[ch[i]-'a'].push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++){
            if(forbidden.contains(i) || ch[i]=='*') continue;
            sb.append(ch[i]+"");
        }

        return sb.toString();
    }
}