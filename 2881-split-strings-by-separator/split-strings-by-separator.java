class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        
        List<String> ans = new ArrayList<>();

        for(String s : words){
            char[] ch = s.toCharArray();
            int n = ch.length;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                if(ch[i]!=separator) sb.append(ch[i]);
                else{
                    if(sb.length()==0) continue;
                    ans.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if(sb.length()!=0) ans.add(sb.toString());
        }
        return ans;
    }
}