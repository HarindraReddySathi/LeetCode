class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        if(n>m) return false;
        int[] alpha1 = alphabetArrayCreator(s1,0,n);
        int[] alpha2 = alphabetArrayCreator(s2,0,n);
        for(int i=0;i<m-n;i++){
            if(valid(alpha1,alpha2)) return true;
            alpha2[s2.charAt(i)-'a']--;
            alpha2[s2.charAt(i+n)-'a']++;
        }
        if(valid(alpha1,alpha2)) return true;
        return false;
    }

    public boolean valid(int[] a,int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i])return false;
        }
        return true;
    }

    public int[] alphabetArrayCreator(String s,int start,int end){
        int[] alpha = new int[26];
        for(int i=start;i<end;i++){
            alpha[s.charAt(i)-'a']++;
        }
        return alpha;
    }
}