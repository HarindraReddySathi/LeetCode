class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int i =0;
        int j=0;
        while(i<n && j<n){
            while(j<n && ch[j]!=' '){
                j++;
            }
            reverse(i,j-1,ch);
            i=++j;
        }
        return String.valueOf(ch);
    }
    public void reverse(int i,int j,char[] ch){

        while(i<j){
            char temp = ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
    }
}