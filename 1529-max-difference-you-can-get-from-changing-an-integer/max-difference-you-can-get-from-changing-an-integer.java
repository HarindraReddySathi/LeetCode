class Solution {
    public int maxDiff(int num) {
        
        char[] ch = String.valueOf(num).toCharArray();
        int n = ch.length;
        //To get Maximum
        char val ='$';
        int count=0;
        for(int i=0;i<n;i++){
            if(ch[i]!='9' && val =='$'){
                val = ch[i];
                ch[i]='9';
                //System.out.println(ch[i]);
                count++;
                continue;
            }
            if(ch[i]==val){
                ch[i]='9';
                //System.out.println(ch[i]);
                continue;
            }
            //System.out.println(ch[i]);
        }
        //if(count==0)Arrays.fill(ch,'8');
        int max = Integer.parseInt(String.valueOf(ch));
        System.out.println(max);
        // To get MIN
        ch = String.valueOf(num).toCharArray();
        val ='$';
        char change ='$';
        count=0;
        for(int i=0;i<n;i++){
            if((val =='$')&& ((i!=0&&ch[i]!='0') || (i==0 && ch[i]!='1'))){
                System.out.println(ch[i]+"----"+ch[0]);
                System.out.println(!(ch[i]==1 && ch[0]==1));
                if(!(ch[i]=='1' && ch[0]=='1')){
                    val = ch[i];
                    ch[i]=(i==0)?'1':'0';
                    change = (i==0)?'1':'0';
                    System.out.println(ch[i]);
                    count++;
                }
                continue;
            }
            if(ch[i]==val){
                ch[i]=change;
                //System.out.println(ch[i]);
                continue;
            }
            //System.out.println(ch[i]);
        }
        int min = Integer.parseInt(String.valueOf(ch));
        System.out.println(min);

        return max-min;
    }
}