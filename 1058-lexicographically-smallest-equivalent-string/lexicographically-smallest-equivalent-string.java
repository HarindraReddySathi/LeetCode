class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        int[] alpha = new int[26];
        for(int i=0;i<26;i++) alpha[i]=i;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int n = ch1.length;
        for(int i =0;i<n;i++){
            int left = findParent(ch1[i]-'a',alpha);
            int right = findParent(ch2[i]-'a',alpha);
            if(left<=right){
                alpha[right] = left;
            }else{
                alpha[left] = right;
            }
        }

        StringBuilder sb = new StringBuilder();
        char[] ch = baseStr.toCharArray();
        for(char c : ch){
            sb.append((char)(findParent(c-'a',alpha)+'a')+"");
        }
        //for(int i=0;i<26;i++) System.out.println((char)(i+'a') +" -- "+ (char)(alpha[i]+'a'));
        return sb.toString();
    }

    public int findParent(int i , int[] alpha){

        if(alpha[i]==i) return i;
        alpha[i] = findParent(alpha[i],alpha);
        return alpha[i];
    }
}