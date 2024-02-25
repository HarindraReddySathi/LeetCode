class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<>();
        int sl = s.length();
        int pl = p.length();
        if(pl>sl) return ans;
        int[] pChar = new int[26];
        int[] sChar = new int[26];
        char[] pCh = p.toCharArray();
        char[] sCh = s.toCharArray();
        for(char c : pCh){
            pChar[c-'a']++;
        }
        for(int i=0;i<pl;i++){
            sChar[sCh[i]-'a']++;
        }
        if(check(sChar,pChar)) ans.add(0);
        for(int i=1;i<=sl-pl;i++){
            sChar[sCh[i-1]-'a']--;
            sChar[sCh[i+pl-1]-'a']++;
            if(check(sChar,pChar)) ans.add(i);
        }
        return ans;
    }

    public boolean check(int[] sChar,int[] pChar){

        for(int i=0;i<26;i++){
            if(sChar[i]!=pChar[i]) return false;
        }
        return true;
    }

}