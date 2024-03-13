class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        
        int n = word.length();
        char[] ch = word.toCharArray();
        int p =0;
        String temp = "";
        for(int i=0;i<k;i++)temp+="*";
        while(true){
            p++;
            word = word.substring(k,n)+temp;
            if(compareTwoString(ch,word.toCharArray(),n)) return p;
        }
    }
    public boolean compareTwoString(char[] ch,char[] word,int n){

        for(int i=0;i<n;i++){
            if(word[i]=='*') continue;
            if(word[i]!=ch[i]) return false;
        }
        return true;
    }
}