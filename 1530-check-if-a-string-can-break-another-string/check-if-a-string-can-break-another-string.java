class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        int n = s1.length();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for(int i=0;i<n;i++){
            a1[ch1[i]-'a']++;a2[ch2[i]-'a']++;
        }
        boolean ans = true;
        int dec = 0;
        int sum1 =0;
        int sum2= 0;
        for(int i=0;i<26;i++){
            sum1 += a1[i];
            sum2 += a2[i];
            if(sum1==sum2) continue;
            if((sum1>sum2 && dec<0) ||(sum1<sum2 && dec>0)) return false;
            if(sum1>sum2) dec =1;
            else dec =-1;
        }
        return true;
    }
}