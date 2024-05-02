class Solution {
    public String reversePrefix(String word, char ch) {
        
        char[] c = word.toCharArray();
        int n = c.length;
        int j =-1;
        for(int i =0;i<n;i++){
            if(c[i]==ch){
                j=i;
                break;
            }
        }
        if(j==-1) return word;
        int i =0;
        while(j>=i){
            char temp = c[i];
            c[i]=c[j];
            c[j]=temp;
            j--;i++;
        }
        return new String(c);
    }
}