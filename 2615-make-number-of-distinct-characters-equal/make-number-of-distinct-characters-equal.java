class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] w1 = new int[26];
        int d1 = 0;
        int[] w2 = new int[26];
        int d2 = 0;
        for (char c : word1.toCharArray()) {
            if (w1[c - 'a'] == 0)
                d1++;
            w1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            if (w2[c - 'a'] == 0)
                d2++;
            w2[c - 'a']++;
        }
        /*if(d1==d2){
            int count=0;
            for(int i =0;i<26;i++){
                if((w1[i]>0 && w2[i]>0)|| (w1[i]==0 && w2[i]==0))count++;
            }
            if(count==26) return true;
        }*/
        if(d1<d2){
            return finder(w2,d2,w1,d1);
        }else{
            return finder(w1,d1,w2,d2);
        }
        
    }
    public boolean finder(int[] w1,int d1,int[] w2,int d2){

        for(int i =0;i<26;i++){
            if(w1[i]==0) continue;
            for(int j=0;j<26;j++){
                if(w2[j]==0) continue;
                if(i==j && d1==d2) return true;
                if(i==j) continue;
                int p1=d1;
                int p2=d2;
                if(w1[j]==0) p1++;
                if(w2[i]==0) p2++;
                if(w1[i]==1) p1--;
                if(w2[j]==1) p2--;
                if(p1==p2) return true;
            }
        }
        return false;
    }
}