class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int n = croakOfFrogs.length();
        char[] ch = croakOfFrogs.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        map.put('c',0);map.put('r',1);map.put('o',2);map.put('a',3);map.put('k',4);
        int[] ap = new int[5];
        int ans =0;
        int pend =0;
        for(char c : ch){
            int cur = map.get(c);
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
}