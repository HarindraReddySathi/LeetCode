class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] alphabet = new int[26];
        //sentence=sentence.toLowerCase();
        char[] ch = sentence.toCharArray();
        int n = ch.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(ch[i]>='a'&&ch[i]<='z'){
                if(alphabet[ch[i]-'a']==0){
                    count++;
                    alphabet[ch[i]-'a']++;
                }
            }
            if(count==26) return true;
        }
        /*StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if(alphabet[i]==0){
                char c = (char)('a'+i);
                sb.append(c);
            }
        }
        System.out.println(sb.toString());*/
        //if(count==26) return true;
        return false;
    }
}