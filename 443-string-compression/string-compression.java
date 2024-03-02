class Solution {
    public int compress(char[] ch) {
        
        int n = ch.length;
        int i=0,j=0;
        int count=0;
        while(i<n && j<n){
            char c = ch[j];
            while(j<n && ch[j]==c){
                count++;
                j++;
            }
            ch[i]=c;
            if(count!=1){
                String str = String.valueOf(count);
                for(int q=0;q<str.length();q++){
                    ch[++i]=str.charAt(q);
                }
            }
            count=0;
            i++;
        }
        return i;
    }
}