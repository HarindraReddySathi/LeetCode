class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int n = croakOfFrogs.length();
        char[] ch = croakOfFrogs.toCharArray();
        int[] ap = new int[5];
        int ans =0;
        int pend =0;
        for(char c : ch){
            int cur = dec(c);
            if(cur==0){
                ap[cur]++;
                if(pend==0) ans++;
                else pend--;
            }else if(cur!=4){
                if(ap[cur-1]!=0){
                    ap[cur-1]--;
                    ap[cur]++;
                }else{
                    return -1;
                }
            }else{
                if(ap[cur-1]!=0){
                    ap[cur-1]--;
                    pend++;
                }else{
                    return -1;
                }
            }
        }
        for(int i =0;i<4;i++){
            if(ap[i]!=0) return -1;
        }
        return ans;
    }

     public int dec(char a) {
        
        if(a=='c')
        return 0;
        if(a=='r')
        return 1;
        if(a=='o')
        return 2;
        if(a=='a')
        return 3;
        if(a=='k')
        return 4;
        return -1;
    }
}