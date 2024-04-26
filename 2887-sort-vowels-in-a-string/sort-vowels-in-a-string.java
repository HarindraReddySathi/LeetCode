class Solution {
    public String sortVowels(String s) {
        
        char[] ch = s.toCharArray();
        int n = ch.length;

        Map<Integer,Integer> map = new TreeMap<>();

        for(char c : ch){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'|| c=='A' || c=='E' || c=='I' ||
            c=='O' || c=='U'){
                        int cur = (int)c;
                        map.put(cur,map.getOrDefault(cur,0)+1);
            }
        }

        for(int i =0;i<n;i++){
            char c = ch[i];
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'|| c=='A' || c=='E' || c=='I' ||
            c=='O' || c=='U'){
                char cur = '*';
                for(int j : map.keySet()){
                    if(map.get(j)!=0){
                        cur = (char)j;
                        map.put(j,map.getOrDefault(j,0)-1);
                        break;
                    }
                }
                ch[i]=cur;
            }
        }

        return String.valueOf(ch);
    }
}