class Solution {
    public int maxDiff(int num) {
        
        char[] ch = Integer.toString(num).toCharArray();
        int n = ch.length;
        //high
        char high = 'p';
        for(char c : ch){
            if(c!='9'){
                high=c;
                break;
            }
        }
        //Low
        char low = 'p';
        int val = 1;
        if(ch[0]!='1'){
            //System.out.println("****");
            low = ch[0];
        }
        //System.out.println(high + " --- "+low);
        if(low=='p'){
            val=0;
            for(char c : ch){
                if(c!='0' && c!='1'){
                    low=c;
                    break;
                }
            }
        }
        //System.out.println(high + " --- "+low);
        /// Calculation
        int ans =0;
        int cur =1;
        for(int i=n-1;i>=0;i--){
            int fac =0;
            if(ch[i]==high) fac =9;
            else fac = ch[i]-'0';
            if(ch[i]==low) fac -=val;
            else fac -= ch[i]-'0';
            ans+=(cur*fac);
            cur*=10;
        }
        return ans;
        
    }
}