class Solution {
    public int removeAlmostEqualCharacters(String word) {
        
        char[] ch = word.toCharArray();
        int n = ch.length;
        int i=0,j=1,ans=0,temp =1;
        while(j<n){
            while(j<n && (ch[j]==ch[i]||ch[j]-ch[i]==1||ch[i]-ch[j]==1)){
                temp++;
                i++;
                j++;
            }
            ans+=temp/2;
            if(j==n) break;
            j++;
            i=j-1;
            temp=1;
        }
        return ans;
    }
}