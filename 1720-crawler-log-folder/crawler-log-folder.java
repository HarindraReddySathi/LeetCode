class Solution {
    public int minOperations(String[] logs) {
        
        int ans=0;
        for(String log : logs){
            if("../".equals(log)){
                if(ans>0) ans--;
            }else if("./".equals(log)){
                continue;
            }else{
                ans++;
            }
        }
        return ans;
    }
}