class Solution {
    public int appendCharacters(String s, String t) {
        
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int n1 = ch1.length;
        int n2 = ch2.length;
        int i =0;
        int j=0;
        while(i<n1 && j<n2){
            if(ch1[i]==ch2[j]){
                j++;
            }
            i++;
        }
        if(j==n2) return 0;
        return n2-j;
    }
}