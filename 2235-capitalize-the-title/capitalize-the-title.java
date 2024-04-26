class Solution {
    public String capitalizeTitle(String t) {
        
        int n = t.length();
        char[] ch = t.toCharArray();
        int i=0,j=0;
        while(j<n){

            while(j<n && ch[j]!=' '){
                j++;
            }
            int cur = j-i;
            if(cur>2){
                camelCase(ch,i,j);
            }else{
                toLowerCase(ch,i,j);
            }
            j++;
            i=j;
        }
        return String.valueOf(ch);
    }

    public void camelCase(char[] ch,int i,int j){

        if(ch[i]>='a' && ch[i]<='z')ch[i] = (char)(ch[i]-'a'+'A');
        for(int s=i+1;s<j;s++){
            if(ch[s]>='A' && ch[s]<='Z')ch[s] = (char)(ch[s]-'A'+'a');
        }
    }
    public void toLowerCase(char[] ch,int i,int j){
        for(int s=i;s<j;s++){
            if(ch[s]>='A' && ch[s]<='Z')ch[s] = (char)(ch[s]-'A'+'a');
        }
    }
}