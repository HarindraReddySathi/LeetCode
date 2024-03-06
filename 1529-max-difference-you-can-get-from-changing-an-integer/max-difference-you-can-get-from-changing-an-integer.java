class Solution {
    public int maxDiff(int num) {
        
        char[] high = Integer.toString(num).toCharArray();
        char[] low = Integer.toString(num).toCharArray();
        int n = high.length;

        //high
        char x ='$';
        char y = '9';
        if(high[0]!='9') x=high[0];
        else{
            for(int i=0;i<n;i++){
                if(high[i]!='9'){
                    x=high[i];
                    break;
                }
            }
        }
        if(x!='$'){
            for(int i=0;i<n;i++){
                if(high[i]==x) high[i]=y;
            }
        }

        //Low
        x ='$';
        y = '0';
        if(low[0]!='1'){
            x=low[0];
            y='1';
        }
        else{
            for(int i=0;i<n;i++){
                if(low[0]=='1' && low[i]!='0' && low[i]!='1'){
                    x=low[i];
                    break;
                }
                if(low[0]!='1' && low[i]!='0'){
                    x=low[i];
                    break;
                }
            }
        }
        if(x!='$'){
            for(int i=0;i<n;i++){
                if(low[i]==x) low[i]=y;
            }
        }

        /// Calculation
        int h = Integer.parseInt(String.valueOf(high));
        int l = Integer.parseInt(String.valueOf(low));
        System.out.println(h+"--"+l);
        return (h-l);
    }
}