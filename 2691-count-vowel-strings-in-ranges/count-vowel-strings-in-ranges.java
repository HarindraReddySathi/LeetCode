class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        Set<Character> isVowels = new HashSet<>();
        isVowels.add('a');isVowels.add('e');isVowels.add('i');isVowels.add('o');
        isVowels.add('u');
        int[] vowels = new int[n];
        int prefix =0;
        for(int i=0;i<n;i++){
            char[] ch = words[i].toCharArray();
            int dec = (isVowels.contains(ch[0]) && isVowels.contains(ch[ch.length-1]))?1:0;
            vowels[i]=dec+prefix;
            prefix = vowels[i];
        }
        int[] ans = new int[queries.length];
        int pos=0;
        for(int[] i : queries){
            int end = vowels[i[1]];
            int start = (i[0]==0)?0:vowels[i[0]-1];
            ans[pos++]=end-start;
        }
        return ans;
    }
}