class Solution {
    public String decodeMessage(String key, String message) {
        
        int[] alpha = new int[26];
        int[] decodeKey = new int[26];
        char[] ch = key.toCharArray();
        int kl = ch.length;
        int pos=0;
        for(int i=0;i<kl;i++){
            if(ch[i]==' ') continue;
            if(alpha[ch[i]-'a']>0) continue;
            alpha[ch[i]-'a']++;
            decodeKey[ch[i]-'a']=pos;
            pos++;
        }
        ch = message.toCharArray();
        int ml = ch.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ml;i++){
            if(ch[i]==' '){
                sb.append(" ");
            }else{
                int cur = ch[i]-'a';
                char c = (char)(decodeKey[cur]+'a');
                sb.append(c+"");
            }
        }
        return sb.toString();
    }
}