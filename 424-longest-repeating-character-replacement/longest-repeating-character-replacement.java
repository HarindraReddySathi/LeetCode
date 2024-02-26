class Solution {
    public int characterReplacement(String s, int k) {
        
        int ans = 0;
        int n= s.length();
        char[] ch = s.toCharArray();
        if(n==1 ||(k==n-1))return n;
        int[] alphabets = new int[26];
        int i =0;
        alphabets[ch[0]-'A']++;
        int j=1;
        alphabets[ch[1]-'A']++;
        while(i<n && j<n){
            if(!decision(alphabets,k)){
                alphabets[ch[i]-'A']--;
                i++;
            }else{
                if(ans<(j-i+1)) ans= j-i+1;
                j++;
                if(j<n)alphabets[ch[j]-'A']++;
            }
        }
        
        return ans;
    }

    public boolean decision(int[] alphabets,int k){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<26;i++){
            if(alphabets[i]>max)max = alphabets[i];
            sum+=alphabets[i];
        }
        if(k>=sum-max)return true;
        return false;
    }
}