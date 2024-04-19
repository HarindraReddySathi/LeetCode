class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        char[] ch = s.toCharArray();
        int n = ch.length;
        int ans =0;
        while(!isAchieved(ch,n)){
            ans++;
            int i=0,j=1;
            while(j<n){
                if(ch[i]=='0' && ch[j]=='1'){
                    char t = ch[i];
                    ch[i++] = ch[j];
                    ch[j++]=t;
                }
                i++;j++;
            }
        }
        return ans;
    }

    public boolean isAchieved(char[] ch,int n){

        char c = ch[0];
        if(ch[0]==0){
            for(int i=0;i<n;i++){
                if(ch[i]!='0') return false;
            }
        }else{
            for(int i =0;i<n;i++){
                if(ch[i]=='1' && c=='1') continue;
                else if(ch[i]=='0' && c=='1'){
                    c='0';
                }else if(ch[i]=='1' && c=='0'){
                    return false;
                }
            }
        }
        return true;
    }
}