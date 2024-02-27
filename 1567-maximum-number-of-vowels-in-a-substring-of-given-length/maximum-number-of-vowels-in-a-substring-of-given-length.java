class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        boolean[] alpha = new boolean[26];
        alpha['a'-'a']=true; alpha['e'-'a']=true; alpha['i'-'a']=true; alpha['o'-'a']=true; alpha['u'-'a']=true;
        int n = s.length();
        char[] ch = s.toCharArray();
        int max = 0;
        int count=0;
        for(int i=0;i<k;i++){
            //if(vowels.contains(s.charAt(i))) count++;
            if(alpha[ch[i]-'a']) count++;
        }
        //System.out.println(count);
        max=Math.max(max,count);
        for(int i=1;i<n-k+1;i++){
            //if(vowels.contains(s.charAt(i-1))) count--;
            //if(vowels.contains(s.charAt(i+k-1))) count++;
            if(alpha[ch[i-1]-'a']) count--;
            if(alpha[ch[i+k-1]-'a']) count++;
            //System.out.println(count);
            max=Math.max(max,count);
            //System.out.println(max);
        }
        return max;
    }
}